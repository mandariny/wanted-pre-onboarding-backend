package wanted.pre.onboarding.jobportal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wanted.pre.onboarding.jobportal.dto.RecruitResponse;
import wanted.pre.onboarding.jobportal.dto.RecruitRequest;
import wanted.pre.onboarding.jobportal.service.RecruitService;

@RestController
@RequestMapping("/recruit")
@RequiredArgsConstructor
public class RecruitController {

    private final RecruitService recruitService;

    @PostMapping("/{companyId}")
    public ResponseEntity<RecruitResponse> postRecruit(
            @PathVariable final Long companyId,
            @RequestBody final RecruitRequest recruitRequest){

        RecruitResponse response = recruitService.saveRecruit(companyId, recruitRequest);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{recruitId}")
    public ResponseEntity<RecruitResponse> updateRecruit(
            @PathVariable final Long recruitId,
            @RequestBody final RecruitRequest recruitRequest){

        RecruitResponse response = recruitService.updateRecruit(recruitId, recruitRequest);

        return ResponseEntity.ok().body(response);
    }
}
