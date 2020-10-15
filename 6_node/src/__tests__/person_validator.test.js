const {validate, _isNameValid} = require('../person_validator');

describe('Dummy Test', ()=>{
    it('tests if true is true',()=>{
       expect(true).toBe(true); 
    });
});

describe('Person Validator Tests',()=>{

    let validCallbackMock = jest.fn();
    let rejectCallbackMock = jest.fn();

    beforeEach(()=>{
        jest.clearAllMocks();
    });

    it('tests the happy path', ()=>{
        const person = {
            name : "John Doe",
            nationality : "american",
            birthDate : '1999-12-13',
            phone : "+36 90 1234567",
            email : "john@doe.com",
        };
        validate(person,validCallbackMock,rejectCallbackMock);

        expect(validCallbackMock).toHaveBeenCalled();
        expect(rejectCallbackMock.mock.calls).toEqual([]);
    });

    it('tests if a person has 4 names',()=>{
        const person = {
            name : "John Johnny Jack Doe",
            nationality : "american",
            birthDate : '1999-12-13',
            phone : "+36 90 1234567",
            email : "john@doe.com",
        };
        validate(person,validCallbackMock,rejectCallbackMock);

        expect(validCallbackMock).toHaveBeenCalled();
        expect(rejectCallbackMock.mock.calls).toEqual([]);
    });
    
    it('tests if a person has MORE THAN 4 names',()=>{
        const person = {
            name : "John Johnny Jack Joe Doe",
            nationality : "american",
            birthDate : '1999-12-13',
            phone : "+36 90 1234567",
            email : "john@doe.com",
        };
        validate(person,validCallbackMock,rejectCallbackMock);

        expect(validCallbackMock.mock.calls.length).toBe(0);
        expect(rejectCallbackMock.mock.calls[0][0]).toEqual(['name']);
    });

    it('tests if a name ends space',()=>{
        const person = {
            name : "John Doe ",
            nationality : "american",
            birthDate : '1999-12-13',
            phone : "+36 90 1234567",
            email : "john@doe.com",
        };
        validate(person,validCallbackMock,rejectCallbackMock);

        expect(validCallbackMock.mock.calls.length).toBe(0);
        expect(rejectCallbackMock.mock.calls[0][0]).toEqual(['name']);
    });
});