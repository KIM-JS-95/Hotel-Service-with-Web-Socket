-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hotel
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hotel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hotel` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `hotel` ;

-- -----------------------------------------------------
-- Table `hotel`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel`.`room` (
  `idx` BIGINT NOT NULL AUTO_INCREMENT,
  `roomnum` VARCHAR(45) NULL DEFAULT NULL,
  `bedtype` VARCHAR(45) NULL DEFAULT NULL,
  `people` VARCHAR(45) NULL DEFAULT NULL,
  `st` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idx`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotel`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel`.`admin` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `room` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `phonenum` VARCHAR(45) NULL DEFAULT NULL,
  `room_idx` BIGINT NOT NULL,
  `checkinTime` DATETIME NOT NULL,
  `checkoutTime` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_admin_Room_idx` (`room_idx` ASC) VISIBLE,
  CONSTRAINT `admin_ibfk_1`
    FOREIGN KEY (`room_idx`)
    REFERENCES `hotel`.`room` (`idx`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hotel`.`guest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hotel`.`guest` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `phonenum` VARCHAR(45) NULL DEFAULT NULL,
  `start` VARCHAR(45) NULL DEFAULT NULL,
  `end` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
