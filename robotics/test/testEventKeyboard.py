def controlRobotKeyboard():
    from pynput import keyboard

    kold = ""
    def on_press(key):
        kold = ""
        k = key.name
        if k == "left" and k != kold:
            print("left")
            return
        elif k == "right" and k != kold:
            print("right")
            return
        elif k == "up" and k != kold:
            print("up")
            return
        elif k == "down" and k != kold:
            print("down")
            return
        elif k == "space" and k != kold:
            print("space")
            return

    while True:
        listener = keyboard.Listener(on_press=on_press)
        listener.start()  # start to listen on a separate thread
        listener.join()  # remove if main thread is polling self.keys

controlRobotKeyboard()