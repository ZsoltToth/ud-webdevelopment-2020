const {logger} = require('./logger');

const _isNameValid = (name) =>{
    return name.match(/^([A-Z][a-z]+\s?){2,4}$/g) != null;
}

const validatePerson = (
    {name, nationality, phone, email, birthDate}
    ) => {
    logger.info(`Validate ${name}`);
    //Name:
    // - 2-4 words
    // - only letters
    // - Each Word Starts With Capital Letter
    if(!_isNameValid(name)){
        logger.warn(`Invalid Name: ${name}`);
    }
}

module.exports = {
    validate : validatePerson
}
