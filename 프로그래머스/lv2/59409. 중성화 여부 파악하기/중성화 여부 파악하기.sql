-- IF문 IF(조건절, 참일 때 값, 거짓일 때 값)

SELECT ANIMAL_ID, NAME, 
IF(SEX_UPON_INTAKE LIKE '%Neutered%' OR SEX_UPON_INTAKE LIKE '%Spayed%','O','X') AS '중성화'
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;