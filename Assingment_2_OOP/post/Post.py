from __future__ import annotations

from typing import TYPE_CHECKING, Set

if TYPE_CHECKING:
    from User import User

from abc import ABC, abstractmethod

from CostomException import NotLoginError
from Notificator import Notificator

class Post(ABC):
