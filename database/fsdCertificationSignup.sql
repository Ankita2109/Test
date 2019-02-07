SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `fsdCertificationSignup` ;
CREATE SCHEMA IF NOT EXISTS `fsdCertificationSignup` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `fsdCertificationSignup` ;

-- -----------------------------------------------------
-- Table `fsdCertificationSignup`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fsdCertificationSignup`.`role` ;

CREATE  TABLE IF NOT EXISTS `fsdCertificationSignup`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT ,
  `ro_user_role` VARCHAR(45) NULL ,
  PRIMARY KEY (`ro_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fsdCertificationSignup`.`language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fsdCertificationSignup`.`language` ;

CREATE  TABLE IF NOT EXISTS `fsdCertificationSignup`.`language` (
  `la_id` INT NOT NULL AUTO_INCREMENT ,
  `la_name` VARCHAR(45) NULL ,
  `la_language_code` VARCHAR(10) NULL ,
  PRIMARY KEY (`la_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fsdCertificationSignup`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fsdCertificationSignup`.`user` ;

CREATE  TABLE IF NOT EXISTS `fsdCertificationSignup`.`user` (
  `id` INT NULL AUTO_INCREMENT ,
  `us_name` VARCHAR(45) NULL ,
  `us_email` VARCHAR(55) NULL ,
  `us_password` VARCHAR(10) NULL ,
  `us_ro_id` INT NULL ,
  `us_la_id` INT NULL ,
  `us_blacklisted` VARCHAR(3) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `us_ro_fk` (`us_ro_id` ASC) ,
  INDEX `us_la_fk` (`us_la_id` ASC) ,
  CONSTRAINT `us_ro_fk`
    FOREIGN KEY (`us_ro_id` )
    REFERENCES `fsdCertificationSignup`.`role` (`ro_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `us_la_fk`
    FOREIGN KEY (`us_la_id` )
    REFERENCES `fsdCertificationSignup`.`language` (`la_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fsdCertificationSignup`.`article-favourite`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fsdCertificationSignup`.`article-favourite` ;

CREATE  TABLE IF NOT EXISTS `fsdCertificationSignup`.`article-favourite` (
  `af_id` INT NOT NULL AUTO_INCREMENT ,
  `af_author` VARCHAR(30) NULL ,
  `af_title` VARCHAR(100) NULL ,
  `af_description` VARCHAR(500) NULL ,
  `af_name` VARCHAR(60) NULL ,
  `af_la_id` INT NULL ,
  PRIMARY KEY (`af_id`) ,
  INDEX `af_la_fk` (`af_la_id` ASC) ,
  CONSTRAINT `af_la_fk`
    FOREIGN KEY (`af_la_id` )
    REFERENCES `fsdCertificationSignup`.`language` (`la_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fsdCertificationSignup`.`article`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fsdCertificationSignup`.`article` ;

CREATE  TABLE IF NOT EXISTS `fsdCertificationSignup`.`article` (
  `ar_id` INT NOT NULL AUTO_INCREMENT ,
  `ar_af_id` INT NULL ,
  `ar_us_id` INT NULL ,
  PRIMARY KEY (`ar_id`) ,
  INDEX `ar_af_fk` (`ar_af_id` ASC) ,
  INDEX `ar_us_fk` (`ar_us_id` ASC) ,
  CONSTRAINT `ar_af_fk`
    FOREIGN KEY (`ar_af_id` )
    REFERENCES `fsdCertificationSignup`.`article-favourite` (`af_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ar_us_fk`
    FOREIGN KEY (`ar_us_id` )
    REFERENCES `fsdCertificationSignup`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
