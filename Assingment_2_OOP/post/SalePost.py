from __future__ import annotations

from typing import TYPE_CHECKING

if TYPE_CHECKING:
    from User import User
from CostomException import InvalidCredentialsError
from post.Post import Post


class SalePost(Post):
    def __init__(self, creator: User, product_name: str, price: float, city: str):
        super().__init__(creator)
        self._product_name = product_name
        self._price = price
        self._city = city
        self._is_Sold = False  # boolean variable to know the state of the product

    def discount(self, dis: float, password: str) -> None:
        """
        Giving a discount on the product by a given password, if the user is a follower of the post publisher
        :param dis: discount in percentage - a float between 0 and 100
        :param password: The password of the post publisher/creator
        :return: None
        """
        if dis <= 0 or dis > 100:
            raise ValueError("Discount must be in the range (0,100]")

        if super().get_creator().compare_password(password):
            self._price = self._price * (1 - dis / 100)
            print(f"Discount on {super().get_creator().username} product! the new price is: {self._price}")
        else:
            raise InvalidCredentialsError("Invalid credentials")

    def sold(self, password: str) -> None:
        """
        Updating the product as sold if depending on a given password.
        In addition, printing a message that it has been sold
        :param password: the password of the post creator/publisher
        :return: None
        """
        if super().get_creator().compare_password(password):
            self._is_Sold = True  # We are selling the product
            print(f"{super().get_creator().username}\'s product is sold")

    def __repr__(self):
        return f'{super().get_creator().username} posted a product for sale:\n{"Sold!" if self._is_Sold else "For sale"} {self._product_name}, price: {self._price}, pickup from: {self._city}\n'
