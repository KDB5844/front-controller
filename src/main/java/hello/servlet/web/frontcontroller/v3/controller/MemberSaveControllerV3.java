package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.HashMap;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        String username = (String)(paramMap.get("username"));
        int age = Integer.parseInt(paramMap.get("age"));

        Member newMember = memberRepository.save(new Member(username, age));

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", newMember);

        return new ModelView("save-result");
    }
}
