package com.vote2.api;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vote2.api.functions.FuncDatas;
import com.vote2.api.models.MdlClearRed;
import com.vote2.api.models.MdlColorMode;
import com.vote2.api.models.MdlGetDataVote;
import com.vote2.api.models.MdlGetMaxDateTime;
import com.vote2.api.models.MdlGetShowCountActive;
import com.vote2.api.models.MdlLogId;
import com.vote2.api.models.MdlMaxPersonId;
import com.vote2.api.models.MdlParam;
import com.vote2.api.models.MdlPhotoPath;
import com.vote2.api.models.MdlPopupPosition;
import com.vote2.api.models.MdlResult;
import com.vote2.api.models.MdlRowColor;
import com.vote2.api.models.MdlSortMode;
import com.vote2.api.models.MdlTotalScore;
import com.vote2.api.models.MldCountMode;
import com.vote2.api.models.MldSelectStatus;

@RestController
public class Vote2Service {

    @Value("${spring.database.url}")
    private String url;
    @Value("${spring.database.username}")
    private String username;
    @Value("${spring.database.password}")
    private String password;

    @GetMapping("/getPhotoPath")
    public MdlPhotoPath getPhotoPath() {
        FuncDatas funcdata = new FuncDatas();
        MdlPhotoPath mdlPhotoPath = new MdlPhotoPath();
        mdlPhotoPath = funcdata.getPhotoPath(url, username, password);
        return mdlPhotoPath;
    }

    @GetMapping("/getRowColor")
    public MdlRowColor getRowColor() {
        FuncDatas funcdata = new FuncDatas();
        MdlRowColor mdlRowColor = new MdlRowColor();
        mdlRowColor = funcdata.getRowColor(url, username, password);
        return mdlRowColor;
    }

    @GetMapping("/getTotalScore")
    public MdlTotalScore getTotalScore() {
        FuncDatas funcdata = new FuncDatas();
        MdlTotalScore mdlTotalScore = new MdlTotalScore();
        mdlTotalScore = funcdata.getTotalScore(url, username, password);
        return mdlTotalScore;
    }

    @GetMapping("/getMaxLogId")
    public MdlLogId getMaxLogId() {
        FuncDatas funcdata = new FuncDatas();
        MdlLogId mdlLogId = new MdlLogId();
        mdlLogId = funcdata.getMaxLogId(url, username, password);
        return mdlLogId;
    }
    
    @GetMapping("/getMaxPersonId")
    public MdlMaxPersonId getMaxPersonId() {
        FuncDatas funcdata = new FuncDatas();
        MdlMaxPersonId mdlMaxPersonId = new MdlMaxPersonId();
        mdlMaxPersonId = funcdata.getMaxPersonId(url, username, password);
        return mdlMaxPersonId;
    }

    @GetMapping("/getPersonIdLogId")
    public MdlMaxPersonId getPersonIdLogId() {
        FuncDatas funcdata = new FuncDatas();
        MdlMaxPersonId mdlMaxPersonId = new MdlMaxPersonId();
        mdlMaxPersonId = funcdata.getPersonIdLogId(url, username, password);
        return mdlMaxPersonId;
    }
    
    @GetMapping("/getClearRed")
    public MdlClearRed getClearRed() {
        FuncDatas funcdata = new FuncDatas();
        MdlClearRed mdlClearRed = new MdlClearRed();
        mdlClearRed = funcdata.getClearRed(url, username, password);
        return mdlClearRed;
    }

    @GetMapping("/getSortMode")
    public MdlSortMode getSortMode() {
        FuncDatas funcdata = new FuncDatas();
        MdlSortMode mdlSortMode = new MdlSortMode();
        mdlSortMode = funcdata.getSortMode(url, username, password);
        return mdlSortMode;
    }

    @GetMapping("/getColorMode")
    public MdlColorMode getColorMode() {
        FuncDatas funcdata = new FuncDatas();
        MdlColorMode mdlColorMode = new MdlColorMode();
        mdlColorMode = funcdata.getColorMode(url, username, password);
        return mdlColorMode;
    }
    
    @GetMapping("/getData")
    public List<MdlGetDataVote> getData(@RequestParam int sortMode) {
        FuncDatas funcdata = new FuncDatas();
        List<MdlGetDataVote> mdlGetDataVoteList = new ArrayList<MdlGetDataVote>();
        int sortModeInt = sortMode;
        mdlGetDataVoteList = funcdata.getData(sortModeInt, url, username, password);
        return mdlGetDataVoteList;
    }
    
    @GetMapping("/getCountMode")
    public MldCountMode getCountMode() {
        FuncDatas funcdata = new FuncDatas();
        MldCountMode mldCountMode = new MldCountMode();
        mldCountMode = funcdata.getCountMode(url, username, password);
        return mldCountMode;
    }
    //this function is not used
    @GetMapping("/getSelectStatus") 
    public MldSelectStatus getSelectStatus() {
        FuncDatas funcdata = new FuncDatas();
        MldSelectStatus mldSelectStatus = new MldSelectStatus();
        mldSelectStatus = funcdata.getSelectStatus(url, username, password);
        return mldSelectStatus;
    }

    @PostMapping("/updateClearSelect")
    public MdlResult updateClearSelect() {
        FuncDatas funcdata = new FuncDatas();
        MdlResult mdlResult = new MdlResult();
        mdlResult = funcdata.updateClearSelect(url, username, password);
        return mdlResult;
    }
    
    @GetMapping("/getParam")
    public MdlParam getParam(@RequestBody String paramId) {
        FuncDatas funcdata = new FuncDatas();
        MdlParam mdlParam = new MdlParam();
        int paramIdInt = Integer.parseInt(paramId);
        mdlParam = funcdata.getParam(paramIdInt, url, username, password);
        return mdlParam;
    }

    @GetMapping("/getShowCountActive")
    public MdlGetShowCountActive getShowCountActive() {
        FuncDatas funcdata = new FuncDatas();
        MdlGetShowCountActive mdlGetShowCountActive = new MdlGetShowCountActive();
        mdlGetShowCountActive = funcdata.getShowCountActive(url, username, password);
        return mdlGetShowCountActive;
    }
    
    @GetMapping("/getMaxDateTime")
    public MdlGetMaxDateTime getMaxDateTime() {
        FuncDatas funcdata = new FuncDatas();
        MdlGetMaxDateTime mdlGetMaxDateTime = new MdlGetMaxDateTime();
        mdlGetMaxDateTime = funcdata.getMaxDateTime(url, username, password);
        return mdlGetMaxDateTime;
    }
    
    @PostMapping("/updateClearShow")
    public MdlResult updateClearShow() {
        FuncDatas funcdata = new FuncDatas();
        MdlResult mdlResult = new MdlResult();
        mdlResult = funcdata.updateClearShow(url, username, password);
        return mdlResult;
    }

    @GetMapping("/getPopupPosition")
    public MdlPopupPosition getPopupPosition() {
        FuncDatas funcdata = new FuncDatas();
        MdlPopupPosition mdlPopupPosition = new MdlPopupPosition();
        mdlPopupPosition = funcdata.getPopupPosition(url, username, password);
        return mdlPopupPosition;
    }
    
    
    
}
