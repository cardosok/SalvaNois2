projeto2.sql
Mês passado
22 de mai
k
Você fez o upload de 1 item
Arquivo desconhecido
projeto2.sql
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema projeto2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema projeto2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `projeto2` DEFAULT CHARACTER SET utf8 ;
USE `projeto2` ;


-- -----------------------------------------------------
-- Table `projeto2`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto2`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(100) NOT NULL,
  `isAdmin` BIT(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `projeto2`.`publicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `projeto2`.`publicacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `imagem` VARCHAR(500) NULL,
  `video` VARCHAR(500) NULL,
  `texto` VARCHAR(500) NULL,
  `data_publicacao` DATETIME NULL,
  `usuarios_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_publicacao_usuarios1_idx` (`usuarios_id` ASC),
  CONSTRAINT `fk_publicacao_usuarios1`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `projeto2`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;