CREATE TABLE bottom (
  bottomId INT(11) NOT NULL,
  flavourBot VARCHAR(45) NULL DEFAULT NULL,
  priceBot INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (bottomId));
  
CREATE TABLE user1 (
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  admin TINYINT(1) NULL DEFAULT NULL,
  userId INT(11) NOT NULL,
  balance INT(10) UNSIGNED NULL DEFAULT NULL,
  email VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (userId),
  UNIQUE INDEX username(username));

CREATE TABLE order1 (
  OrderId INT(11) primary key auto_increment,
  User_userId INT(11) NOT NULL,
  CONSTRAINT fk_Order_User1
    FOREIGN KEY user1(User_userId)
    REFERENCES user1(userId));

CREATE TABLE topping(
  toppingId INT(11) NOT NULL,
  flavourTop VARCHAR(45) NULL DEFAULT NULL,
  priceTop INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (toppingId));
  
CREATE TABLE odetails(
  Order_orderId INT(11),
  totalPrice int(11) NOT NULL,
  quantity INT UNSIGNED NULL,
  bottom_bottomId INT(11) NOT NULL,
  topping_toppingId INT(11) NOT NULL,
  primary key (Order_orderId, bottom_bottomId, topping_toppingId),
  CONSTRAINT fk_Cupcake_has_Order_Order1
    FOREIGN KEY (Order_orderId)
    REFERENCES order1(orderId),
  CONSTRAINT fk_odetails_bottom1
    FOREIGN KEY (bottom_bottomId)
    REFERENCES bottom(bottomId),
  CONSTRAINT fk_odetails_topping1
    FOREIGN KEY (topping_toppingId)
    REFERENCES topping(toppingId));