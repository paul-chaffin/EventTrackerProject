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
INSERT INTO `coffee` (`id`, `ounces`, `creamer`, `sugar_tbsp`, `date_time`) VALUES (1, 6, 1, .5, '2022-06-04T07:45:25');
INSERT INTO `coffee` (`id`, `ounces`, `creamer`, `sugar_tbsp`, `date_time`) VALUES (2, 8, 1, 1, '2022-06-04T08:33:25');

COMMIT;
