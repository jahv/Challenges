package utils;

import com.google.common.base.Strings;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileHandlingTest {

    @Test
    public void test() throws Exception {

        String paths[] = new String[]{
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-business-tier/src/main/resources/com/choicehotels/pms/application/RPMconfiguration.xml",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-business-tier/src/main/resources/com/choicehotels/pms/application/pmsconfiguration.xml",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-business-tier/src/test/java/com/choicehotels/pms/application/RPMconfiguration.xml",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-business-tier/src/test/java/com/choicehotels/pms/application/pmsconfiguration.xml",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/java/com/choicehotels/pmweb/actions/ReservationInitializeAction.java",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/java/com/choicehotels/pmweb/actions/guestprofile/GuestProfileMembershipValidationAction.java",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/RoomTypePopUpDetails.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/WEB-INF/views/jsp/demo/test1.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/WEB-INF/views/jsp/demo/test2.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/WEB-INF/views/jsp/demo/test3.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/WEB-INF/views/jsp/mobile/housekeeping/room_detail.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/WEB-INF/views/jsp/mobile/housekeeping/room_search.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/WEB-INF/views/jsp/mobile/housekeeping/room_status_condition.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/WEB-INF/views/jsp/mobile/sign_in_choose_property_mobile.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/accountsReceivable_inactivate_report.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/accountsReceivable_list.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/addressPopUp/addressPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/assignRoom.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/cacheComponents/propertyInfoMenu.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/change_room_rate_information.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/change_stay.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/check_in_successful.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/check_out_folio_report_params.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/check_out_successful.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/check_out_successful_from_departures.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/checkin/check_in_paymentInfo.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/checkin/check_in_regCard_report_params.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/checkin/check_in_successful.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/clc/clcPleaseConfirm.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/clc/clcVoiceAuthCenter.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/companyProfile/companySelectPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/companyProfile/createCompanyProfile.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/companyProfileSummaryList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/companyProfile_update.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/businessInformationPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/cashierShift.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/creditCardSelection/creditCardSelectionPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/editInterfaceOptions.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/giftCard/additionalOptions.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/giftCard/detailGiftCards.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/guestProfile/guestProfileFindFormInclude.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/guestProfile/resultsList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/override.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/recurringCharges/detailRecurringCharge.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/reservationNoSale/reservation_no_sale.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/roomBlocking/detailWorkOrder.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/sendElectronicFacturaBusinessInformationPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/userFeedbackForm.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/validAddressRequired/validAddressRequiredPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/components/voiceAuthorization.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/config/keys.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/cpenrollment/CPEnrollmentCompleted.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/cpenrollment/cpEnrollmentDisplay.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/creditCardProcessing/creditWarningsChecklist.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/creditCardProcessing/debitCardAlertPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/creditCardProcessing/voiceAuthorizationCenter.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/credit_card_receipts.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/crsNotifications/crsNotificationDetail.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/crsNotifications/crsNotifications.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/customReports/customReports.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/deviceAccessCookie/deviceAccessCookieDisplay.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/emailProforma.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/emailTaxInvoice.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/enterpriseReporting/enterpriseReportingContent.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/enterpriseReporting/enterpriseReportingDisplayParameters.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/enterpriseReporting/enterpriseReportingDisplayReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/enterpriseReporting/propertySetCreateContent.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/enterpriseReporting/propertySetListContent.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/fastPost/fastPost.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/fastPost/fastPostGroupAccounts.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/fastPost/fastPostGuestAccounts.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/fastPost/fastPostHouseAccounts.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/futureAvailability/futureAvailabilityUpdateSellingPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/generate_forecast_confirmation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/generate_forecast_warning.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/giftCard/balanceInquiry.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/giftCard/giftCardCenter.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/giftCard/issueGiftCard.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/globalSearch/SearchSkytouchOSModal.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/gopher/gopherModule1.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/gopher/gopherModule2.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/gopher/gopherPopUpMenu.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/gopher/gopherTest.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/gopherMain.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/components/assignUnassignRooms.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/components/detailGroupMasterEditBlocks.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/components/detailGroupMasterEditRates.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/components/detailGroupMasterEditReservations.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/components/groupMasterBlocksTab.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/components/groupMasterCancelReasons.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/components/optionsGroupMasterEditBlocks.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/components/rowGroupMasterEditRates.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/components/viewGroupContractEmail.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/editGroupRatesPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/goCapsule_createGroupMaster.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/go_groupMasterViewGuarantee.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/go_groupMasterViewInformation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/groupMasterFind.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/groupMasterQuickPickups.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/groupMasterViewNotes_go.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/groupMasterViewReservations.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/roomingList/email_rooming_list_csv.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/roomingList/roomingList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/roomingList/roomingListAddNamesPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/roomingList/roomingListEditGuestPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/roomingList/roomingListEditSharesPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groupMaster/roomingList/roomingListViewImport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/group_folio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groups/groupContractViewUpdate.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groups/groupReservationSummaryList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/groups/groupsListInCompanyProfile.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/CPLookupForm.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/chooseRewardsProgramPopUpNewStyle.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/components/confirmMergeDialog.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/components/guestProfileLookupForm.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/components/guestProfileOverviewActions.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/editRewardsProgramPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/guestProfileEditNamesPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/guestProfileEditPreferences.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/guestProfileExtendedDataPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/guestProfileFinalizeMerge.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/guestProfileMembershipPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/guestProfileMerge.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/guestProfileNotesPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/guestProfileSpecialRequestPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestProfile/guestProfileStayList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalCPEnroll.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalCPEnrollConf.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalCPEnrollGuestInfo.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalCPEnrollInProgress.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalCPEnrollSuccessful.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalCheckinSuccessful.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalContactInfo.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalDisclaimer.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalRatesAndPayment.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalShowSign.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalSignVerify.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guestTerminal/guestTerminalStayInfo.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/guest_folio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/automaticRoomAssignmentPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/creditCardSurchargeConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/glAccountConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/propertyConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/roomConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/roomConfigurationAddEditRoomPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/roomTypeConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/roomTypeConfigurationAddEditRoomPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/taxRateConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/taxRateConfigurationEditTaxRatePopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/transactionCodeConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/transactionCodeConfigurationEditTaxPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/caConfigTool/transactionCodeConfigurationViewCodePopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/cashierShift/cashierShiftConfig.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/clc/corporateLodging.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/configureDefaultAuthorization.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/directBillAccount/directBillAccount.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/extendedGuestData/extendedGuestData.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/guestTerminalConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/hotelConfigurationMain.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/housekeeping/housekeepingConfigurationAdd.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/housekeeping/housekeepingConfigurationEdit.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/housekeeping/roomConditionConfigDialog.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/idScanConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/keyEncoderConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/minimum_rates_overrides.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/nightAuditReportConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/paymentControllerConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/rateOverride/rateOverrideReason.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/socialMediaLinks.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/tracking_codes_AssociateRatePlans.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/hotelConfiguration/travelAgentCommission.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/houseAccount/houseAccountInformation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/houseAccount/houseAccountPaymentInfo.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/houseAccount/houseAccountViewInformation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/house_account_by_state.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/house_account_folio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/housekeeping/assignHousekeepersTab.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/housekeeping/components/cleaningScheduleConfirmation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/housekeeping/components/rangeEditOptions.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/housekeeping/roomCleaningSchedule.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/housekeeping/updateRoomConditionRows.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/howTos/howTos.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/innerHTML/innerHTMLCashierShift.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/innerHTML/innerHTMLOverride.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/innerHTML/reportRelayPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/invoice_detail.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/invoice_update.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/jediInterface/synchronize_interface.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/login_popup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/lookups/lookupCompanyDirectBill.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/m/user_authenticated.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/night_audit_in_progress.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/night_audit_reports.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/night_audit_run.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/noShow/noShowReservationBatchResultsSection.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/noShow/noShowReservationBatchSearchSection.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/no_show_successful.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/onboarding/onboarding.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/onboarding/onboardingCreateProperty.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/override_successful.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/packages/packageCRSCalculatePopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/packages/packageChargeAddPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/packages/packageEstimateCostPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/packages/packageInformation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/packages/packageRates.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/packages/packageSelectPackagePopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/partialAuth.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/passwordExpirationNotification/passwordChange.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/payMultipleInvoices/payMultipleInvoicesPayment.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/payMultipleInvoices/payMultipleInvoicesResults.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/payMultipleInvoices/payMultipleInvoicesSelect.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/phone_number_capture.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/print/closedFolios.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/print/groupProformaPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/print/invoiceSelectionList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/print/proformaPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/print/taxInvoicePopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/propertyNotConfigured.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/propertySelection/enterpriseSelectProperty.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/propertySelection/selectProperty.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/quick_stats.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/rateChangeVerificationPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/recurringCharges/recurringChargeAddEditPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/redirect.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportDueToDepartFolios.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportServer/folio/findArchivedFolio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportServer/folio/rowFindArchivedFolio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportServer/invoice/findArchivedInvoice.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports/expressCheckoutFolio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports/forecastOverview.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports/groupContract.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports/groupDepositDue.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports/groupFinalPickup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports/groupPickups.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports/reports_email_invoices.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports/reports_email_statements.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/ArrivalExportReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/AwardsRedemptionReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/accommodationReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/accountInformationExportReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/advancePurchaseReservation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/archivedFolio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/archivedInvoice.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/backOfficeReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/businessOnTheBooks.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/cashRenewalReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/cityTaxReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/companyHistoryMasterList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/companyHistoryReportExtended.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/companyHistoryStatistics.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/companyHistoryTop50.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/complimentaryRoomsReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/creditCardDecryptionReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/creditCheckReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/depositDueList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/dueToDepartFolios.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/experienceRedemptionReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/expressCheckoutFolio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/findArchivedInvoiceResults.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/forecastOverviewReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/futurePackageReservationsReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/futureReservations.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupActionableNotes.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupArrivalListReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupCutoff.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupDepartureList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupLabels.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupMasterList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupPickupDetails.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupPickupSummary.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupReservationList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupReservationStatus.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupRoomsControlLog.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/groupStatus.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/guestHistoryMailingLabels.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/guestHistoryMasterList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/guestHistoryTop50.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/guestProfile.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/highBalanceReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/historicalRevenueDetail.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/historicalRevenueSummary.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/historicalStayMix.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/hotelJournalSummary.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/hotelStatistics.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/housekeepingDoNotDisturbReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/housekeepingRoomAssignment.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/idGuestReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/lengthOfStayComparison.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/maintenanceReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/nationalityStatisticsReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/noPostReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/noShowReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/onTheBooksStayMix.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/printEmergencyReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/quickBooksReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/rateDiscrepancyReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/revenueByBookingSource.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/revenueByRateCodeSummary.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/rewardProgramsStatisticsDetail.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/rewardProgramsStatisticsSummary.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/roomMoveReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/roomUsageReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/rowFindArchivedFolio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/specialRequests.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/systemAccessReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/taxExemptReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/tieredSalesStatus.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/topFeederMarketReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/tourismStatisticsReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/transactionForecastChargesDetailReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/transactionForecastChargesReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/travelAgentCommission.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/forms/vatReport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/reportView.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reportsTier/reportsSecurity/reportsSecurityAssign.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports_email_folio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports_email_group_folio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports_email_rooming_list_csv.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports_group_arrival_list.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports_group_departure_list.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports_guest_history_mailing_labels.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports_guest_history_master_list.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports_guest_history_top50.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reports_print_folio.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reservation/emailFolio/emailFolio_go.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reservation/groups/groupGuestChangeRoomRateInformation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reservation/keyIssuePopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reservation/updateRoomConditionDialog.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reservationChangeRoomPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reservation_change_history.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reservation_confirmation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/reservation_room_rate_information.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/roomBlocking/guestList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/roomBlocking/roomTypeExcludedFromRatePlanPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/roomBlocking/tapeChart.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/roomBlocking/workOrder.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/salesVATDataExtract/salesVatDataExtract.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/secureRedirect.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/shares/sharesBillingInformationPopUp.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/shares/sharesConfigureNames.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/shiftRecCloseout.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/sign_in_DeskTop.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/sign_in_Mobile.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/smartWelcomeStats.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/specialRequest/specialRequestCodeConfiguration.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/specialRequest/specialRequestGuestPopup.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/synchronize_inventory_confirmation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/synchronize_inventory_warning.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/synchronize_minimum_rates_warning.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/taxInvoice/findTaxInvoice.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/taxProfile/taxProfileMain.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/template/includeForExport.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/template/reports_genericForm.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/template/reward/experienceRuleTopSection.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/template/reward/rewardConfigurationIf.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/template/reward/rewardConfigurationThen.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/termsOfUse.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/testing/test1.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/testing/test2.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/travelAgent/travelAgentCreate.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/travelAgent/travelAgentFind.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/travelAgent/travelAgentList.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/twoFactorAuthentication.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/twoFactorAuthentication/mobileNumberEdit.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/user_authenticated.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/viewEditReservation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/view_arrivals_list.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/view_checked_out_list.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/view_departures_list.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/view_house_keeping_status.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/view_in_house_list.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/view_most_recent_accounts.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/view_room_block_OOO.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/walkin_confirmation.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/warning_CreditBalance.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/welcome.jsp",
                "/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp/workOrder/workOrderConfigurationEdit.jsp"
        };

//        String paths[] = new String[]{
//                "/Users/ahernandez/Desktop/test.jsp"
//        };
        for(int i=0; i<paths.length; i++) {
            String name = paths[i].substring(paths[i].lastIndexOf("/"),paths[i].length());
            String status =  "NO APPLY";
            if(name.endsWith(".jsp")) {
                String search = "uri=\"http://jakarta.apache.org/struts/tags-html\"";
                StringBuilder stringBuilder = FileHandling.validateFileContains(paths[i], search);
                status = "OK";
                if(stringBuilder.length() > 0) {
                    status = "WRONG";

                    int lastTaglib = stringBuilder.lastIndexOf("<%@ taglib");
                    if(lastTaglib != -1) {
                        int lastLine = stringBuilder.indexOf("\n", lastTaglib);
                        stringBuilder.insert(lastLine, "\n<%@ taglib uri=\"http://jakarta.apache.org/struts/tags-html\" prefix=\"html\" %>");


                    } else {
                        lastTaglib = stringBuilder.indexOf("--%>");
                        int lastLine = stringBuilder.indexOf("\n", lastTaglib);
                        stringBuilder.insert(lastLine, "\n<%@ taglib uri=\"http://jakarta.apache.org/struts/tags-html\" prefix=\"html\" %>");
                    }

                    Files.write(Paths.get(paths[i]), stringBuilder.toString().getBytes());

                }
            }
            System.out.println("[" + i + "] : " + name + " - " + status);
        }
    }

    @Test
    public void testListFiles() throws Exception {
        List<String> files = FileHandling.listFiles("/Users/ahernandez/git/SkyTouch/choiceAdvantage9/choiceadvantage/choiceADVANTAGE-web-tier/src/main/webapp", ".jsp");
//        List<String> files = File
// Handling.listFiles("/Users/ahernandez/Desktop/testJSP", "jsp");
        int i =0;
        for(String file : files) {
            StringBuilder stringBuilder = FileHandling.validateFileContains(file, "<form", "<html:form");
            if(stringBuilder.length() > 0) {
                i++;
//                process(stringBuilder, "<form");
//                process(stringBuilder, "<html:form");
//                Files.write(Paths.get(file), stringBuilder.toString().getBytes());
            }
        }
        System.out.println(i);
    }


    private void process(StringBuilder stringBuilder, String search){
        String input = "<input type=\"hidden\" name=\"FORM_TOKEN\" value=\"<c:out value='${sessionScope.FORM_TOKEN}'/>\" />";
        int indexForm = stringBuilder.indexOf(search);

        while(indexForm != -1) {
            int indexLine = stringBuilder.indexOf("\n", indexForm);
            int space = stringBuilder.indexOf("<",indexLine);
            int spaces = stringBuilder.substring(indexLine, space).length() - 1;

            stringBuilder.insert(indexLine, "\n" + Strings.repeat(" ", spaces) + input);

            indexForm = stringBuilder.indexOf(search, indexLine);
        }
    }

    @Test
    public void testListFileNamesContains() throws Exception {
        Map<String, String> files = FileHandling.listFilesNameContains("/Users/ahernandez/git/Personal/GitHub/Challenges/src/test/Resources/files", "Skyhook.log.2018-08-22.*");
        System.out.println(files);
    }


    @Test
    public void getMetricsOfLog() throws Exception {
//        Map<String, String> files = FileHandling.listFilesNameContains("/Users/ahernandez/git/Personal/GitHub/Challenges/src/test/Resources/files", "Skyhook.log.2018-08-22.*");
        Map<String, String> files = FileHandling.listFilesNameContains("/Users/ahernandez/Documents/SkyTouch/HOOK/HOOK-20 Out of Memory Error Encountered", "Skyhook.log.2018-08-22.*");
//        System.out.println(files);
        Map<FileHandling.LogInfo, Integer> metrics = FileHandling.getStatistics(files);

        System.out.println("\n============================\n");
        for(FileHandling.LogInfo logInfo : metrics.keySet()) {
            System.out.println(logInfo.getFileName() + "\t" + logInfo.getDateTime() + "\t" + metrics.get(logInfo));
        }

    }
}
