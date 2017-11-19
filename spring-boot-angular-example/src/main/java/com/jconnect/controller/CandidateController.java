package com.jconnect.controller;

import com.jconnect.assemblers.CandidateAssembler;
import com.jconnect.domain.Candidate;
import com.jconnect.repo.CandidateRepository;
import com.jconnect.service.CandidateService;
import com.jconnect.vo.CandidateVO;
import com.jconnect.vo.CreateCandidateVO;
import com.jconnect.vo.UpdateCandidateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/candidate")
public class CandidateController {

    @Autowired
    private CandidateAssembler candidateAssembler;

    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CandidateVO getUser(@PathVariable("id") Long id) {
        return candidateAssembler.toUserVO(candidateService.getCandidateById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public CandidateVO createUser(@RequestBody CreateCandidateVO userVO) {
        //convert to User
        Candidate user = candidateAssembler.toUser(userVO);
        //save User
        Candidate savedUser = candidateService.createCandidate(user);
        //convert to UserVO
        return candidateAssembler.toUserVO(savedUser);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public CandidateVO updateUser(@RequestBody UpdateCandidateVO updateUserVO) {
        //convert to User
        Candidate user = candidateAssembler.toUser(updateUserVO);
        //update User
        Candidate updatedUser = candidateService.updateCandidate(user);
        //convert to UserVO
        return candidateAssembler.toUserVO(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        candidateService.deleteCandidate(id);
    }


//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public Candidate getCandidate(@PathVariable("id") Long id){
//        return candidateRepository.findOne(id);
//    }

    //    private List<Candidate> users = new ArrayList();
//
//    CandidateController() {
//        //this.users = buildUsers();
//    }
//
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Candidate> getUsers() {
//        return this.users;
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Candidate getUser(@PathVariable("id") Long id) {
//        return this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Candidate saveUser(@RequestBody Candidate user) {
//        Long nextId = 0L;
//        if (this.users.size() != 0) {
//            Candidate lastUser = this.users.stream().skip(this.users.size() - 1).findFirst().orElse(null);
//            nextId = lastUser.getId() + 1;
//        }
//
//        user.setId(nextId);
//        this.users.add(user);
//        return user;
//
//    }
//
//    @RequestMapping(method = RequestMethod.PUT)
//    public Candidate updateUser(@RequestBody Candidate user) {
//        Candidate modifiedUser = this.users.stream().filter(u -> u.getId() == user.getId()).findFirst().orElse(null);
//        modifiedUser.setFirstName(user.getFirstName());
//        modifiedUser.setLastName(user.getLastName());
//        modifiedUser.setEmail(user.getEmail());
//        return modifiedUser;
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public boolean deleteUser(@PathVariable Long id) {
//        Candidate deleteUser = this.users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
//        if (deleteUser != null) {
//            this.users.remove(deleteUser);
//            return true;
//        } else  {
//            return false;
//        }
//
//
//    }
//
//    List<Candidate> buildUsers() {
//        List<Candidate> users = new ArrayList<>();
//
//        Candidate user1 = buildUser(1L, "John", "Doe", "john@email.com", "3453123");
//        Candidate user2 = buildUser(2L, "Jon", "Smith", "smith@email.com", "13453");
//        Candidate user3 = buildUser(3L, "Will", "Craig", "will@email.com",  "1112");
//        Candidate user4 = buildUser(4L, "Sam", "Lernorad", "sam@email.com", "123412");
//        Candidate user5 = buildUser(5L, "Ross", "Doe", "ross@email.com", "56423");
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//        users.add(user4);
//        users.add(user5);
//
//        return users;
//
//    }
//
//    Candidate buildUser(Long id, String fname, String lname, String email, String phone) {
//        Candidate user = new Candidate();
//        user.setId(id);
//        user.setFirstName(fname);
//        user.setLastName(lname);
//        user.setEmail(email);
//        user.setPhone(phone);
//        return user;
//    }
}
