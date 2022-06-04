-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema seltzerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `seltzerdb` ;

-- -----------------------------------------------------
-- Schema seltzerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `seltzerdb` DEFAULT CHARACTER SET utf8 ;
USE `seltzerdb` ;

-- -----------------------------------------------------
-- Table `seltzer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `seltzer` ;

CREATE TABLE IF NOT EXISTS `seltzer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ounces` INT NOT NULL,
  `date_time` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `coffee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coffee` ;

CREATE TABLE IF NOT EXISTS `coffee` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ounces` INT NOT NULL,
  `creamer` TINYINT NULL,
  `sugar_tbsp` FLOAT NULL,
  `date_time` DATETIME NOT NULL,
  `origin` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `beer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `beer` ;

CREATE TABLE IF NOT EXISTS `beer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brewer` VARCHAR(45) NOT NULL,
  `style` VARCHAR(45) NOT NULL,
  `style_2` VARCHAR(45) NULL,
  `name` VARCHAR(45) NOT NULL,
  `origin` VARCHAR(45) NOT NULL,
  `abv` FLOAT NOT NULL,
  `purveyor` VARCHAR(45) NULL,
  `date_time` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS seltzeruser;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'seltzeruser' IDENTIFIED BY 'seltzeruser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'seltzeruser';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `seltzer`
-- -----------------------------------------------------
START TRANSACTION;
USE `seltzerdb`;
INSERT INTO `seltzer` (`id`, `ounces`, `date_time`) VALUES (1, 32, '2022-06-04T09:17:25');

COMMIT;


-- -----------------------------------------------------
-- Data for table `coffee`
-- -----------------------------------------------------
START TRANSACTION;
USE `seltzerdb`;
INSERT INTO `coffee` (`id`, `ounces`, `creamer`, `sugar_tbsp`, `date_time`, `origin`) VALUES (1, 6, 1, .5, '2022-06-04T07:45:25', 'Brazil');
INSERT INTO `coffee` (`id`, `ounces`, `creamer`, `sugar_tbsp`, `date_time`, `origin`) VALUES (2, 8, 1, 1, '2022-06-04T08:33:25', 'Brazil');
INSERT INTO `coffee` (`id`, `ounces`, `creamer`, `sugar_tbsp`, `date_time`, `origin`) VALUES (3, 8, 0, 0.0, '2022-06-03T13:16:41', 'Colombia');
INSERT INTO `coffee` (`id`, `ounces`, `creamer`, `sugar_tbsp`, `date_time`, `origin`) VALUES (4, 6, 0, 0.0, '2022-06-03T13:23:22', 'Ethiopia');

COMMIT;


-- -----------------------------------------------------
-- Data for table `beer`
-- -----------------------------------------------------
START TRANSACTION;
USE `seltzerdb`;
INSERT INTO `beer` (`id`, `brewer`, `style`, `style_2`, `name`, `origin`, `abv`, `purveyor`, `date_time`) VALUES (1, 'Bitburger', 'Pilsner', NULL, 'Premium Pils', 'Germany', 4.8, 'Sweet Afton, Astoria, NY', '2022-06-03T20:33:41');
INSERT INTO `beer` (`id`, `brewer`, `style`, `style_2`, `name`, `origin`, `abv`, `purveyor`, `date_time`) VALUES (2, 'Cinco Estrellas', 'Lager', 'European Pale', 'Mahou', 'Spain', 5.5, 'City Fresh, Astoria, NY', '2022-04-02T17:00:00');
INSERT INTO `beer` (`id`, `brewer`, `style`, `style_2`, `name`, `origin`, `abv`, `purveyor`, `date_time`) VALUES (3, 'Grupo Modelo S.A. de C.V.', 'Lager', 'Adjunct', 'Modelo Especial', 'Mexico', 4.4, 'Beer Mart, Astoria, NY', '2022-06-03T21:15:00');
INSERT INTO `beer` (`id`, `brewer`, `style`, `style_2`, `name`, `origin`, `abv`, `purveyor`, `date_time`) VALUES (4, 'Grupo Modelo S.A. de C.V.', 'Lager', 'Adjunct', 'Modelo Especial', 'Mexico', 4.4, 'Beer Mart, Astoria, NY', '2022-06-03T21:50:00');
INSERT INTO `beer` (`id`, `brewer`, `style`, `style_2`, `name`, `origin`, `abv`, `purveyor`, `date_time`) VALUES (5, 'Guinness Ltd.', 'Stout', 'Irish Dry', 'Guinness Draught', 'Ireland', 4.2, 'The Bonnie, Astoria, NY', '2022-05-18T20:41:16');
INSERT INTO `beer` (`id`, `brewer`, `style`, `style_2`, `name`, `origin`, `abv`, `purveyor`, `date_time`) VALUES (6, 'Pabst Brewing Company', 'Lager', 'Adjunct', 'Lone Star Beer', 'USA, Texas', 4.65, 'Othello Deli, Astoria, NY', '2021-07-04T16:20:00');
INSERT INTO `beer` (`id`, `brewer`, `style`, `style_2`, `name`, `origin`, `abv`, `purveyor`, `date_time`) VALUES (7, 'Great Lakes Brewing Co.', 'Winter Warmer', NULL, 'Christmas Ale', 'USA, Ohio', 7.5, 'Main Street Tavern, Huron, OH', '2019-12-18T18:30:00');

COMMIT;

