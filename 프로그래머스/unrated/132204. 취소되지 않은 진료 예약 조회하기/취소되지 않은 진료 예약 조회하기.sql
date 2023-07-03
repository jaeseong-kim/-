SELECT  
       T4.APNT_NO,
       T4.PT_NAME,
       T4.PT_NO,
       T4.MCDP_CD,
       T3.DR_NAME,
       T4.APNT_YMD
FROM DOCTOR T3
JOIN (SELECT T1.PT_NAME,
             T1.PT_NO,
             T2.MCDP_CD,
             T2.MDDR_ID,
             T2.APNT_YMD,
             T2.APNT_NO
      FROM PATIENT T1
      JOIN (SELECT PT_NO,
                   MDDR_ID,
                   MCDP_CD,
                   APNT_YMD,
                   APNT_NO
            FROM APPOINTMENT
            WHERE YEAR(APNT_YMD) = 2022 AND 
                  MONTH(APNT_YMD) = 4 AND 
                  DAY(APNT_YMD) = 13 AND 
                  MCDP_CD = 'CS' AND 
                  APNT_CNCL_YN = 'N') T2
            ON T1.PT_NO = T2.PT_NO) T4
ON T3.DR_ID = T4.MDDR_ID
ORDER BY T4.APNT_YMD;