from __future__ import annotations
from typing import TYPE_CHECKING

if TYPE_CHECKING:
   from User import User

class Notificator:
    """
    This class is to notify users.
    This class is an implementation of Observer design pattern
    The register method is not here, but in User class,
    because we notify just the users who are following another user.
    so this is observer for how to notify
    """

    def notify_user(self, user_to_notify: User, notifier: User, message: str, log: bool = False, extra_message: str ="") -> None:
        """
        Notifies a User with a message
        We can also log the message and add to it more info

        :param user_to_notify: how we want to notify
        :param notifier: who's notifying
        :param message: the notification
        :param log: True if we want to log an old message (default is false)
        :param extra_message: the message to add, default is empty
        :return:
            None
        """
        if user_to_notify == notifier: # This is the same user, so don;t notify to myself
            return
        # Notify function from user class, because this is an User object
        user_to_notify.notify(message,log,extra_message)


    def notify_all_followers(self, notifier: User, message: str, log: bool =False)-> None:
        """
        Notifies all user followers
        :param notifier: The user that notifies
        :param message: The message to notify
        :param log: True if you want to log the message (Default to False).

        :return:
            None
        """
        for user in notifier.get_followers():
            self.notify_user(user,notifier,message,log)