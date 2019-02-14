-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema KnittingChart
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema KnittingChart
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `KnittingChart` DEFAULT CHARACTER SET utf8 ;
USE `KnittingChart` ;

-- -----------------------------------------------------
-- Table `KnittingChart`.`Font`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `KnittingChart`.`Font` (
  `fontId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `height` INT NOT NULL,
  `description` TEXT(2000) NULL,
  `sourceName` VARCHAR(200),
  `sourceUrl` VARCHAR(200),
  PRIMARY KEY (`fontId`),
  UNIQUE INDEX `fontId_UNIQUE` (`fontId` ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `KnittingChart`.`Letter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `KnittingChart`.`Letter` (
  `letterId` INT NOT NULL AUTO_INCREMENT,
  `character` CHAR(1) NOT NULL,
  `width` INT NOT NULL,
  `fontId` INT NOT NULL,
  `coordinates` JSON NOT NULL,
  PRIMARY KEY (`letterId`),
  UNIQUE INDEX `letterId_UNIQUE` (`letterId` ASC),
  INDEX `fk_fontId_idx` (`fontId` ASC),
  CONSTRAINT `fontId`
    FOREIGN KEY (`fontId`)
    REFERENCES `KnittingChart`.`Font` (`fontId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

use KnittingChart;
-- -----------------------------------------------------
-- Table `KnittingChart`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `KnittingChart`.`User` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` TEXT NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `KnittingChart`.`Chart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `KnittingChart`.`Chart` (
  `chartId` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `fontId` INT NOT NULL,
  `text` VARCHAR(100) NOT NULL,
  `kerning` int,
  `spacing` int,
  PRIMARY KEY (`chartId`),
  UNIQUE INDEX `chartId_UNIQUE` (`chartId` ASC),
  INDEX `username_idx` (`username` ASC),
  INDEX `fontId_idx` (`fontId` ASC),
  CONSTRAINT `username`
    FOREIGN KEY (`username`)
    REFERENCES `KnittingChart`.`User` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`fontId`)
    REFERENCES `KnittingChart`.`Font` (`fontId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
