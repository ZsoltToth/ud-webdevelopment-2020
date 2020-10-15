const {logger} = require('./logger');

const _isNameValid = (name) =>{
    //Name:
    // - 2-4 words
    // - only letters
    // - Each Word Starts With Capital Letter
    return name.match(/^([A-Z][a-z]+\s?){1,3}([A-Z][a-z]+)$/) != null;
}

const validatePerson = (
    {name, nationality, phone, email, birthDate},
    validCallback,
    rejectCallback
    ) => {
    logger.info(`Validate ${name}`);
    if(!_isNameValid(name)){
        logger.warn(`Invalid Name: ${name}`);
        rejectCallback(['name']);
        return;
    }
    validCallback();
}

module.exports = {
    validate : validatePerson,
    _isNameValid : _isNameValid
}
