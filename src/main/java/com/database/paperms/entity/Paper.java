package com.database.paperms.entity;

import com.database.paperms.entity.type.Impl.PaperType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ClassName: com.database.paperms.entity.Paper
 * Created by zjj
 * Date: 2022-05-04 22:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer paperId;

    private String paperTitle;

    private String paperMeeting;

    private Date paperDate; //数据库中为Date

    private String paperSummary;

    private String paperLink;

    private PaperType paperType;

    private Integer paperPublisherId;

    private Date paperPublishTime; //数据库中为Datetime

    private List<FileEntity> paperAdditionalFile;

    private List<String> paperAuthor;

    private List<Integer> paperCitation;

    private List<String> paperRd;
}
