package com.tadamski.arij.worklog.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tadamski.arij.login.LoginInfo;
import com.tadamski.arij.rest.CommandResult;
import com.tadamski.arij.rest.RESTRunner;
import com.tadamski.arij.rest.command.POSTCommand;
import com.tadamski.arij.rest.exceptions.CommunicationException;
import com.tadamski.arij.util.Jack;

import javax.inject.Inject;
import java.text.MessageFormat;

/**
 * @author tmszdmsk
 */
public class WorkLogRepository {

    private static final String WORKLOG_REPOSITORY = "rest/api/latest/issue/{0}/worklog";
    @Inject
    private RESTRunner restRunner;

    public void addNewWorklogItem(String issueKey, NewWorklog worklog, LoginInfo loginInfo) {
        try {
            String json = Jack.son().writeValueAsString(worklog);
            CommandResult run = restRunner.run(new POSTCommand(json, MessageFormat.format(WORKLOG_REPOSITORY, issueKey)), loginInfo);
            if (run.getCode() != 201) {
                throw new CommunicationException("sth went wrong when posting new worklog for issue:" + issueKey + ", worklog: " + worklog + "."
                        + "Got result: " + run.getCode());
            }
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
