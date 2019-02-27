CREATE DATABASE IF NOT EXISTS drugstoredb;

CREATE TABLE IF NOT EXISTS `drugstoredb`.`drugs` (
  `iddrugs` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `producer` VARCHAR(100) NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`iddrugs`));

CREATE TABLE IF NOT EXISTS `drugstoredb`.`drug_store` (
  `iddrug_store` INT NOT NULL,
  `name` VARCHAR(60) NOT NULL,
  `address` VARCHAR(150) NULL,
  PRIMARY KEY (`iddrug_store`));

CREATE TABLE IF NOT EXISTS `drugstoredb`.`patient` (
  `passport` VARCHAR(8) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birthday` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`passport`));

CREATE TABLE IF NOT EXISTS `drugstoredb`.`prescription` (
  `idprescription` INT NOT NULL AUTO_INCREMENT,
  `prescription_date` VARCHAR(45) NOT NULL,
  `FK_patient_prescription` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`idprescription`),
  INDEX `FK_patient_prescription_idx` (`FK_patient_prescription` ASC),
  CONSTRAINT `FK_patient_prescription`
    FOREIGN KEY (`FK_patient_prescription`)
    REFERENCES `drugstoredb`.`patient` (`passport`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `drugstoredb`.`prescription-drug` (
  `FK_prescription_prescription_drug` INT NOT NULL,
  `FK_drugs_prescription_drug` INT NOT NULL,
  `number` VARCHAR(45) NOT NULL,
  INDEX `FK_drugs_prescription_drug_idx` (`FK_drugs_prescription_drug` ASC),
  INDEX `FK_prescription_prescription_drug_idx` (`FK_prescription_prescription_drug` ASC),
  PRIMARY KEY (`FK_prescription_prescription_drug`, `FK_drugs_prescription_drug`),
  CONSTRAINT `FK_drugs_prescription_drug`
    FOREIGN KEY (`FK_drugs_prescription_drug`)
    REFERENCES `drugstoredb`.`drugs` (`iddrugs`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_prescription_prescription_drug`
    FOREIGN KEY (`FK_prescription_prescription_drug`)
    REFERENCES `drugstoredb`.`prescription` (`idprescription`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `drugstoredb`.`purchase` (
  `idpurchase` INT NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  `payment_status` VARCHAR(25) NOT NULL,
  `FK_drug_store_purchase` INT NOT NULL,
  `FK_prescription_purchase` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idpurchase`),
  INDEX `FK_drug_store_purchase_idx` (`FK_drug_store_purchase` ASC),
  CONSTRAINT `FK_drug_store_purchase`
    FOREIGN KEY (`FK_drug_store_purchase`)
    REFERENCES `drugstoredb`.`drug_store` (`iddrug_store`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
 CONSTRAINT `FK_prescription_purchase`
    FOREIGN KEY (`FK_prescription_purchase`)
    REFERENCES `drugstoredb`.`prescription` (`idprescription`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `drugstoredb`.`purchase-drugs` (
  `FK_purchase_purchase_drugs` INT NOT NULL,
  `FK_drugs_purchase_drugs` INT NOT NULL,
  `number` INT NOT NULL,
  PRIMARY KEY (`FK_purchase_purchase_drugs`, `FK_drugs_purchase_drugs`),
  INDEX `FK_drugs_purchase_drugs_idx` (`FK_drugs_purchase_drugs` ASC),
  CONSTRAINT `FK_purchase_purchase_drugs`
    FOREIGN KEY (`FK_purchase_purchase_drugs`)
    REFERENCES `drugstoredb`.`purchase` (`idpurchase`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_drugs_purchase_drugs`
    FOREIGN KEY (`FK_drugs_purchase_drugs`)
    REFERENCES `drugstoredb`.`drugs` (`iddrugs`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS `drugstoredb`.`drug-drugstore` (
  `FK_drugs_drug_drugstore` INT NOT NULL,
  `FK_drug_store_drug_drugstore` INT NOT NULL,
  `price_for_one` FLOAT NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`FK_drugs_drug_drugstore`, `FK_drug_store_drug_drugstore`),
  INDEX `FK_drugs_drug_drugstore_idx` (`FK_drugs_drug_drugstore` ASC),
  CONSTRAINT `FK_drug_store_drug_drugstore`
    FOREIGN KEY (`FK_drug_store_drug_drugstore`)
    REFERENCES `drugstoredb`.`drug_store` (`iddrug_store`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_drugs_drug_drugstore`
    FOREIGN KEY (`FK_drugs_drug_drugstore`)
    REFERENCES `drugstoredb`.`drugs` (`iddrugs`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);