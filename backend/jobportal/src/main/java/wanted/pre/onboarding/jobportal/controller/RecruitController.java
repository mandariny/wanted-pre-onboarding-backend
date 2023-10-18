package wanted.pre.onboarding.jobportal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wanted.pre.onboarding.jobportal.dto.RecruitPostResponse;
import wanted.pre.onboarding.jobportal.dto.RecruitRequest;
import wanted.pre.onboarding.jobportal.service.RecruitService;

@RestController
@RequestMapping("/recruit")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitService recruitService;

    @PostMapping("/{companyId}")
    public ResponseEntity<RecruitPostResponse> postRecruit(
            @PathVariable final Long companyId,
            @RequestBody final RecruitRequest recruitRequest){

        RecruitPostResponse response = recruitService.saveRecruit(companyId, recruitRequest);

        return ResponseEntity.ok().body(response);
    }
}
