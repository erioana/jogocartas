-- MySQL Workbench Synchronization
-- Generated: 2018-05-10 20:33
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: andrev

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `jogocartas`.`usuarios` (
  `id` INT(11) NOT NULL,
  `nome` VARCHAR(100) NULL DEFAULT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `senha` VARCHAR(70) NULL DEFAULT NULL,
  `qtdmoedas` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `jogocartas`.`partidas` (
  `id` INT(11) NOT NULL,
  `nomepartida` VARCHAR(100) NULL DEFAULT NULL,
  `valoraposta` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nomepartida_UNIQUE` (`nomepartida` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `jogocartas`.`partidasusuarios` (
  `usuarios_id` INT(11) NOT NULL,
  `partidas_id` INT(11) NOT NULL,
  INDEX `fk_table1_usuarios_idx` (`usuarios_id` ASC),
  INDEX `fk_partidasusuarios_partidas1_idx` (`partidas_id` ASC),
  CONSTRAINT `fk_table1_usuarios`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `jogocartas`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_partidasusuarios_partidas1`
    FOREIGN KEY (`partidas_id`)
    REFERENCES `jogocartas`.`partidas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
