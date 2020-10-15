const personValidator = require('./person_validator');

const person = {
    name : "John John John John Doe",
    nationality : "american",
    birthDate : '1999-12-13',
    phone : "+36 90 1234567",
    email : "john@doe.com",
}

personValidator.validate(person);