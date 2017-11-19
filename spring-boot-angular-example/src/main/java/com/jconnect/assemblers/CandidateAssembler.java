package com.jconnect.assemblers;

import com.jconnect.domain.Candidate;
import com.jconnect.util.CandidateUtil;
import com.jconnect.vo.CreateCandidateVO;
import com.jconnect.vo.UpdateCandidateVO;
import com.jconnect.vo.CandidateVO;
import org.springframework.stereotype.Component;

@Component
public class CandidateAssembler {

    /**
     * CreateUserVO convert to User.
     *
     * @param createUserVO
     * @return
     */
    public Candidate toUser(CreateCandidateVO createUserVO) {
        Candidate user = new Candidate();
        user.setFirstName(createUserVO.getFirstName());
        user.setLastName(createUserVO.getLastName());
        user.setEmail(createUserVO.getEmail());
        user.setPhone(createUserVO.getPhone());
        return user;
    }


    /**
     * User to UserVO.
     *
     * @param user
     * @return
     */
    public CandidateVO toUserVO(Candidate user) {
        CandidateVO userVO = new CandidateVO();
        userVO.setUserId(user.getId());
        userVO.setFullName(CandidateUtil.convertToFullName(user.getFirstName(), user.getLastName()));
        userVO.setEmail(user.getEmail());
        userVO.setPhone(user.getPhone());
        return userVO;

    }

    /**
     * UpdateUserVO to user.
     *
     * @param updateUserVO
     * @return
     */
    public Candidate toUser(UpdateCandidateVO updateUserVO) {
        Candidate user = new Candidate();
        user.setId(updateUserVO.getUserId());
        user.setFirstName(updateUserVO.getFirstName());
        user.setLastName(updateUserVO.getLastName());
        user.setEmail(updateUserVO.getEmail());
        user.setPhone(updateUserVO.getPhone());
        return user;
    }
}
