package com.database.paperms.entity.vo;

import com.database.paperms.entity.FileEntity;
import com.database.paperms.entity.ResearchDirection;
import com.database.paperms.entity.SmallPaper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer paperId;

    private String paperTitle;

    private String paperMeeting;

    private Date paperDate; //数据库中为Date

    private String paperSummary;

    private String paperLink;

    private String paperType;

    private UserVO paperPublisher;

    private Date paperPublishTime; //数据库中为Datetime

    private List<FileEntity> paperAdditionalFile;

    private List<String> paperAuthor;

    private List<SmallPaper> paperCitation;

    private List<ResearchDirection> paperRd;


}
