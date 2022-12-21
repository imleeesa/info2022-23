from enum import Enum

class Logger:
    @staticmethod
    def log(level, message):
        print('[' + level.value + '] - ' + message)

class LogLevel(Enum):
    WARNING = 'WRN'
    ERROR = 'ERR'
    INFO = 'INF'
