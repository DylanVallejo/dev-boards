-- MySQL Script generated by MySQL Workbench
-- Thu May  9 11:42:50 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema test_devs
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema test_devs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test_devs` DEFAULT CHARACTER SET utf8 ;
USE `test_devs` ;

-- -----------------------------------------------------
-- Table `test_devs`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_devs`.`company` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_devs`.`position`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_devs`.`position` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `company_id` INT NOT NULL,
  PRIMARY KEY (`id`, `company_id`),
  INDEX `fk_position_company1_idx` (`company_id` ASC) VISIBLE,
  CONSTRAINT `fk_position_company1`
    FOREIGN KEY (`company_id`)
    REFERENCES `test_devs`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_devs`.`developer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_devs`.`developer` (
  `name` VARCHAR(45) NOT NULL,
  `technologys` VARCHAR(45) NULL,
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_devs`.`technology`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_devs`.`technology` (
  `name` INT NULL,
  `id` VARCHAR(45) NOT NULL,
  `position_id` INT NOT NULL,
  `developer_id` INT NOT NULL,
  PRIMARY KEY (`id`, `position_id`, `developer_id`),
  INDEX `fk_technology_position1_idx` (`position_id` ASC) VISIBLE,
  INDEX `fk_technology_developer1_idx` (`developer_id` ASC) VISIBLE,
  CONSTRAINT `fk_technology_position1`
    FOREIGN KEY (`position_id`)
    REFERENCES `test_devs`.`position` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_technology_developer1`
    FOREIGN KEY (`developer_id`)
    REFERENCES `test_devs`.`developer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;