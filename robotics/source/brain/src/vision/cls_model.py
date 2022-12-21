import pathlib
import numpy as np
import os
import PIL
import tensorflow as tf
from tensorflow import keras
from tensorflow.keras import layers
from tensorflow.keras.models import Sequential
from tensorflow.compat.v1 import ConfigProto
from tensorflow.compat.v1 import InteractiveSession

'''
Custom model used for classification machine learning
algorithm
'''
class ClassificationModel:
    def __init__(self, batch_size, img_height, img_width):
        '''
        This is the constructor of my classification
        model.
        Have to pass 3 arguments (batch_size, img_height, img_width)
        '''
        self.batch_size = batch_size
        self.img_height = img_height
        self.img_width = img_width
        self.train_ds = None
        self.val_ds = None
        self.epochs = 10
        self.classes = ['foxcat', 'other']
    
    def fit(self, data_dir):
        '''
        This function is used to create the main datasets:
        - train dataset
        - validation dataset
        '''
        AUTOTUNE = tf.data.AUTOTUNE

        self.train_ds = tf.keras.preprocessing.image_dataset_from_directory(
            data_dir,
            validation_split=0.2,
            subset="training",
            labels='inferred',
            seed=123,
            image_size=(self.img_height, self.img_width),
            batch_size=self.batch_size
        )
        self.val_ds = tf.keras.preprocessing.image_dataset_from_directory(
            data_dir,
            validation_split=0.2,
            labels='inferred',
            subset="validation",
            seed=123,
            image_size=(self.img_height, self.img_width),
            batch_size=self.batch_size
        )
        # improving model performances
        self.train_ds = self.train_ds.cache().shuffle(1000).prefetch(buffer_size=AUTOTUNE)
        self.val_ds = self.val_ds.cache().prefetch(buffer_size=AUTOTUNE)
    
    def layrize_data(self):
        '''
        This functions is used to create the real Sequential model
        and compile it using optimizer.Adam
        '''
        num_classes = 3

        self.model = Sequential([
            layers.experimental.preprocessing.Rescaling(1./255, input_shape=(self.img_height, self.img_width, 3)),
            layers.Conv2D(16, 3, padding='same', activation='relu'),
            layers.MaxPooling2D(),
            layers.Conv2D(32, 3, padding='same', activation='relu'),
            layers.MaxPooling2D(),
            layers.Conv2D(64, 3, padding='same', activation='relu'),
            layers.MaxPooling2D(),
            layers.Flatten(),
            layers.Dense(128, activation='relu'),
            layers.Dense(num_classes)
        ])
        self.model.compile(optimizer='adam',
            loss = tf.keras.losses.SparseCategoricalCrossentropy(from_logits=True),
            metrics=['accuracy']
        )
        self.model.summary()

    def train(self):
        '''
        Function used to fit the Sequential model
        using two datasets loaded before and the current epochs value
        '''
        config = ConfigProto()
        config.gpu_options.allow_growth = True
        session = InteractiveSession(config=config)

        self.history = self.model.fit(
            self.train_ds,
            validation_data=self.val_ds,
            epochs=self.epochs
        )

    def get_class_names(self):
        '''
        Simple function used just to get
        a list with all the categories names
        '''
        if self.train_ds is not None:
            return self.train_ds.class_names
        else:
            return "train_ds model is not fitted"
    
    def save(self, path):
        '''
        Save current model as a .h5 file
        '''
        self.model.save(path)
    
    def load(self, path):
        '''
        Load an existing keras .h5 model
        '''
        self.model = tf.keras.models.load_model(path)

    def predict(self, img_path):
        '''
        Function used to predict an image
        '''
        img = keras.preprocessing.image.load_img(
            img_path, target_size=(self.img_height, self.img_width)
        )
        img_array = keras.preprocessing.image.img_to_array(img)
        img_array = tf.expand_dims(img_array, 0)

        predictions = self.model.predict(img_array)
        score = tf.nn.softmax(predictions[0])

        return self.classes[np.argmax(score)]