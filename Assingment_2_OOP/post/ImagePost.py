from __future__ import annotations

from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from User import User

import matplotlib.pyplot as plt

from PIL import Image
from post.Post import Post


class ImagePost(Post):
    def __init__(self, creator: User, image_path: str):
        super().__init__(creator)
        self._image_path = image_path

    def display(self) -> None:
        print("Show picture")
        img = Image.open(self_image_url)
        plt.imshow(img)
        plt.show()

    def __repr__(self):
        return f'{super().get_creator().username} posted a picture \n'
