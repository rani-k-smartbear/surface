package com.collaborator.tests.autopulling;

import com.collaborator.api.remotesystems.LicenseApiSteps;
import com.collaborator.groupedsteps.GroupedLoginSteps;
import com.collaborator.groupedsteps.GroupedReviewApiSteps;
import com.collaborator.steps.AdminPageSteps;
import com.collaborator.steps.BaseSteps;
import com.collaborator.steps.HomePageSteps;
import com.collaborator.steps.UserApiSteps;
import com.collaborator.steps.review.ReviewFilesApiSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.refresh;

@Slf4j
public class RefreshUI extends BaseSteps {
    @Autowired
    UserApiSteps userApiSteps;
    @Autowired
    AdminPageSteps adminPageSteps;
    @Autowired
    GroupedLoginSteps groupedLoginSteps;

    @Test
    public void refreshLicensePageWithSystemAdmin() throws InterruptedException {
        groupedLoginSteps.loginAsAdmin();
        adminPageSteps.goDirectlyToAdminPage();
        adminPageSteps.goToLicensingPage();
        for (int i = 0; i <1000 ; i++) {
            refresh();
            log.info("Page refreshed - " + (i + 1) + " time");
            Thread.sleep(5000);
        }
    }
}
