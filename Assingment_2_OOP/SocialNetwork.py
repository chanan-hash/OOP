from typing import Dict, Set

from CostomException import UsernameAlreadyExistsError, UserDoesNotExistError, NotLoginError, InvalidCredentialsError
from User import User


class SocialNetwork:

    __instance = None # for implementing Singleton design pattern
    __is_instance = False

    @staticmethod
    def get_instance():
        pass