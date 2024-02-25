class NotLoginError(RuntimeError):
    def __int__(self, error_message):
        self.error_message = error_message


class InvalidPasswordError(RuntimeError):
    def __int__(self, error_message):
        self.error_message = error_message


class UsernameAlreadyExistsError(RuntimeError):
    def __int__(self, error_message):
        self.error_message = error_message


class UserDoesNotExistError(RuntimeError):
    def __int__(self, error_message):
        self.error_message = error_message


class InvalidCredentialsError(RuntimeError):
    def __int__(self, error_message):
        self.error_message = error_message


class IllegalOperationError(RuntimeError):
    def __int__(self, error_message):
        self.error_message = error_message
