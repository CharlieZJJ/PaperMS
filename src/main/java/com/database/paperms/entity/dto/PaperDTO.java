package com.database.paperms.entity.dto;

import com.database.paperms.entity.FileEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaperDTO implements Serializable {

    private List<FileEntity> paperAdditionalFile;

    private List<String> paperAuthor;

    private List<Integer> paperCitation;

    private String paperDate;

    private String paperLink;

    private String paperMeeting;

    private String paperNote;

    private List<List<String>> paperRd;

    private String paperSummary;

    private String paperTitle;

    private Integer paperType;

    private Integer paperPublisherId;

}
