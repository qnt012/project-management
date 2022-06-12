package com.nhnacademy.projectaccountapi.controller;

import com.nhnacademy.projectaccountapi.domain.request.MemberCreateRequest;
import com.nhnacademy.projectaccountapi.entity.Member;
import com.nhnacademy.projectaccountapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<Member>> getMembers() {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(memberService.getMembers());
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public void postInsert(@RequestBody MemberCreateRequest request) {
        memberService.createMember(request);
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable String id) {
        return memberService.getMember(id).orElse(null);
    }

    @GetMapping("/email/{email}")
    public Member getMemberByEmail(@PathVariable String email) {
        return memberService.getMemberByEmail(email).orElse(null);
    }

    @GetMapping("/active/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void getActive(@PathVariable String id) {
        memberService.updateMemberStateActive(id);
    }

    @GetMapping("/dormant/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void getDormant(@PathVariable String id) {
        memberService.updateMemberStateDormant(id);
    }

    @GetMapping("/withdraw/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void getWithdraw(@PathVariable String id) {
        memberService.updateMemberStateWithdraw(id);
    }
}
