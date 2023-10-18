package wanted.pre.onboarding.jobportal.exception;

import org.springframework.http.HttpStatus;

public class NoSuchRecruitException extends MyException{
    private static final String MESSAGE = "존재하지 않는 회사입니다";

    public NoSuchRecruitException(){
        super(MESSAGE, HttpStatus.NOT_FOUND);
    }
}
