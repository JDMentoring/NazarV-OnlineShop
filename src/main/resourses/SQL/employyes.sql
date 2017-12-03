CREATE TABLE IF NOT EXISTS `servlab_shopnv`.`persons` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `f_name` VARCHAR(20) NOT NULL,
  `l_name` VARCHAR(20) NOT NULL,
  `born_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `servlab_shopnv`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) NOT NULL,
  `password` VARCHAR(15) NOT NULL,
  `status` VARCHAR(10) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `servlab_shopnv`.`departments` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `short_name` VARCHAR(10) NOT NULL,
  `full_name` VARCHAR(20) NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `servlab_shopnv`.`job_titles` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title_name` VARCHAR(25) NOT NULL,
  `desc` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `servlab_shopnv`.`employees` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `salary` DOUBLE NOT NULL,
  `hire_date` DATE NOT NULL,
  `created` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `persons_id` INT(11) NOT NULL,
  `users_id` INT(11) NOT NULL,
  `departments_id` INT(11) NOT NULL,
  `job_titles_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_employees_persons_idx` (`persons_id` ASC),
  INDEX `fk_employees_users1_idx` (`users_id` ASC),
  INDEX `fk_employees_departments1_idx` (`departments_id` ASC),
  INDEX `fk_employees_job_titles1_idx` (`job_titles_id` ASC),
  CONSTRAINT `fk_employees_departments1`
    FOREIGN KEY (`departments_id`)
    REFERENCES `servlab_shopnv`.`departments` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employees_persons`
    FOREIGN KEY (`persons_id`)
    REFERENCES `servlab_shopnv`.`persons` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employees_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `servlab_shopnv`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_employees_job_titles1`
    FOREIGN KEY (`job_titles_id`)
    REFERENCES `servlab_shopnv`.`job_titles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;




