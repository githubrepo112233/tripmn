create database tripmn;
use tripmn;

CREATE TABLE User (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  creationTime datetime,
  creatorId varchar(255),
  modifiedTime datetime,
  modifierId varchar(255),
  version int(11),
  userName varchar(255),
  userType int,
  status int,
  firstName varchar(255),
  lastName varchar(255),
  emailId varchar(255),
  mobileNumber varchar(255),
  password varchar(255),
  address varchar(500),
  image blob,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE Account (
  id bigint primary key AUTO_INCREMENT,
  creationTime datetime,
  creatorId varchar(255),
  modifiedTime datetime,
  modifierId varchar(255),
  version int(11),
  user_id bigint,
  accountType int,
  status int,
  availableBalance bigint,
  creditBlockedBalance bigint,
  debitBlockedBalance bigint,
  cumulativeBalance bigint,
  foreign key(user_id) references User(id)
) ENGINE=InnoDB;

CREATE TABLE Item (
  id bigint primary key AUTO_INCREMENT,
  creationTime datetime,
  creatorId varchar(255),
  modifiedTime datetime,
  modifierId varchar(255),
  version int(11),
  name varchar(255),
  categoryType varchar(255),
  description varchar(255),
  brand varchar(255),
  price bigint,
  endDate datetime,
  image blob,
  imagePath varchar(255),
  termsAndConditions varchar(1000),
  isActive bit(1) default true
) ENGINE=InnoDB;

CREATE TABLE Token (
  id bigint primary key AUTO_INCREMENT,
  creationTime datetime,
  creatorId varchar(255),
  modifiedTime datetime,
  modifierId varchar(255),
  version int(11),
  tokenQuantity bigint,
  amount bigint,
  expirtyDate datetime,
  status int default 0
) ENGINE=InnoDB;

CREATE TABLE ItemBidding (
  id bigint primary key AUTO_INCREMENT,
  creationTime datetime,
  creatorId varchar(255),
  modifiedTime datetime,
  modifierId varchar(255),
  version int(11),
  winningUser_id  bigint,
  item_id bigint,
  biddingTokens bigint,
  endDate datetime,
  graceSeconds bigint,
  retryCount bigint,
  status int,
  foreign key(item_id) references Item(id),
  foreign key(winningUser_id) references User(id)
) ENGINE=InnoDB;

CREATE TABLE Transaction (
  id bigint primary key AUTO_INCREMENT,
  creationTime datetime,
  creatorId varchar(255),
  modifiedTime datetime,
  modifierId varchar(255),
  version int(11),
  account_id bigint,
  accountType int,
  status int,
  availableBalance bigint,
  blockedBalance bigint,
  itemBidding_id bigint,
  foreign key(account_id) references Account(id),
  foreign key(itemBidding_id) references ItemBidding(id)
) ENGINE=InnoDB;

CREATE TABLE Coupon (
  id bigint primary key AUTO_INCREMENT,
  creationTime datetime,
  creatorId varchar(255),
  modifiedTime datetime,
  modifierId varchar(255),
  version int(11),
  couponType varchar(255),
  amount bigint,
  couponCode varchar(255),
  expiryDate datetime,
  status int,
  image blob
) ENGINE=InnoDB;

CREATE TABLE UserCoupon (
  id bigint primary key AUTO_INCREMENT,
  creationTime datetime,
  creatorId varchar(255),
  modifiedTime datetime,
  modifierId varchar(255),
  version int(11),
  coupon_id  bigint,
  user_id  bigint
  foreign key(coupon_id) references Coupon(id),
  foreign key(user_id) references User(id)
) ENGINE=InnoDB;

insert into Item(creationTime, creatorId, modifiedTime, modifierId, version, name, description, brand, price, endDate, image, imagePath, termsAndConditions, isActive, categoryType)
values(now(), 1, now(), 1, 1, "Laptop", "Laptop", 'HP', 3500000, '2016-01-01', null, '', '', true, 1),
       (now(), 1, now(), 1, 1, "Laptop", "Laptop", 'DELL', 3500000, '2016-01-01', null, '', '', true, 1),
       (now(), 1, now(), 1, 1, "Camera", "Camera", 'Cannon', 3500000, '2016-01-01', null, '', '', true, 1),
       (now(), 1, now(), 1, 1, "Laptop", "Laptop", 'HP', 3500000, '2016-01-01', null, '', '', true, 1);
	   
insert into Token(creationTime, creatorId, modifiedTime, modifierId, version, tokenQuantity, amount, expiryDate, status)
values(now(), 1, now(), 1, 1, 10, 1000, '2016-01-01', 0),
       (now(), 1, now(), 1, 1, 100, 10000, '2016-01-01', 0);
insert into ItemBidding select 1, now(), 1, now(), 1, 1, 0, now() + interval 10 day, 0, 0, 0, 1, null;
alter table User auto_increment = 4221;
alter table Account auto_increment = 4221;

insert into Coupon select 3567, now(), 1, now(), 1, 1, 100, "NVKCMR0984", "CMRKITCHEN", NOW() + INTERVAL 1 YEAR, 0;
insert into Coupon select 3568, now(), 1, now(), 1, 1, 100, "NVKCMR0989", "PIZZAHUT", NOW() + INTERVAL 1 YEAR, 0;
insert into Coupon select 3569, now(), 1, now(), 1, 1, 100, "NVKCMR9789", "FREECHARGE", NOW() + INTERVAL 1 YEAR, 0;
insert into Coupon select 3570, now(), 1, now(), 1, 1, 100, "NVKCMR9799", "FREECHARGE", NOW() + INTERVAL 1 YEAR, 0;


