package vn.isofh.hl7;


import java.io.IOException;
import java.util.Date;


import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v27.datatype.CWE;
import ca.uhn.hl7v2.model.v27.datatype.PL;
import ca.uhn.hl7v2.model.v27.message.ACK;
import ca.uhn.hl7v2.model.v27.message.OMI_O23;
import ca.uhn.hl7v2.model.v27.message.ORI_O24;
import ca.uhn.hl7v2.model.v27.segment.IN1;
import ca.uhn.hl7v2.model.v27.segment.MSA;
import ca.uhn.hl7v2.model.v27.segment.MSH;
import ca.uhn.hl7v2.model.v27.segment.OBR;
import ca.uhn.hl7v2.model.v27.segment.ORC;
import ca.uhn.hl7v2.model.v27.segment.PID;
import ca.uhn.hl7v2.model.v27.segment.PRT;
import ca.uhn.hl7v2.model.v27.segment.PV1;
import ca.uhn.hl7v2.model.v27.segment.TQ1;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.XMLParser;


public class HL7Convert {
	
	public static String getOMI_O23() {
		String encodedMessage = "";
		
		OMI_O23 msg = new OMI_O23();
		HapiContext context = null;
		try {
			msg.initQuickstart("OMI", "O23", "P");
			MSH msh = msg.getMSH();
			setMSH(msh, 123456);
			PID pid = msg.getPATIENT().getPID();
			setPID(pid);
			IN1 in1 = msg.getPATIENT().getINSURANCE().getIN1();
			setIN1(in1);
			PV1 pv1 = msg.getPATIENT().getPATIENT_VISIT().getPV1();
			setPV1(pv1);
			ORC orc = msg.getORDER().getORC();
			setORC(orc);
			OBR orb = msg.getORDER().getOBR();
			
			context = new DefaultHapiContext();
			
			XMLParser parser = context.getXMLParser();
			encodedMessage = parser.encode(msg);
		} catch (HL7Exception e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(context != null) {
				try {
					context.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return encodedMessage;
	}
	
	public static String getORI_O24() {
		String encodedMessage = "";
		
		ORI_O24 msg = new ORI_O24();
		HapiContext context = null;
		try {
			msg.initQuickstart("ORI", "O24", "P");
			MSH msh = msg.getMSH();
			setMSH(msh, 123456);
			MSA msa = msg.getMSA();
			setMSA(msa, "CA", 123456);
			PID pid = msg.getRESPONSE().getPATIENT().getPID();
			setPID(pid);
			ORC orc = msg.getRESPONSE().getORDER().getORC();
			setORC(orc);
			OBR orb = msg.getRESPONSE().getORDER().getOBR();
			setOBR(orb);
			TQ1 tq1 = msg.getRESPONSE().getORDER().getTIMING().getTQ1();
			setTQ1(tq1);
			PRT prt = msg.getRESPONSE().getORDER().getPRT();
			setPRT(prt);
			
			context = new DefaultHapiContext();
			Parser parser = context.getPipeParser();
			encodedMessage = parser.encode(msg);
		} catch (HL7Exception e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(context != null) {
				try {
					context.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return encodedMessage;
	}
	
	public static String getACK_O23() {
		String encodedMessage = "";
		ACK msg = new ACK();
		HapiContext context = null;
		try {
			msg.initQuickstart("ACK", "O23", "P");
			MSH msh = msg.getMSH();
			setMSH(msh, 123456);
			MSA msa = msg.getMSA();
			setMSA(msa, "CA", 123456);
			
			context = new DefaultHapiContext();
			Parser parser = context.getPipeParser();
			encodedMessage = parser.encode(msg);
		} catch (HL7Exception e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(context != null) {
				try {
					context.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return encodedMessage;
	}
	
	private static void setMSH(MSH msh, int controlID) throws HL7Exception {
		msh.getEncodingCharacters().setValue("^~\\&");
		msh.getSendingApplication().getNamespaceID().setValue("HIS");
		msh.getSendingFacility().getNamespaceID().setValue("ISOFH");
		msh.getReceivingApplication().getNamespaceID().setValue("PACS");
		msh.getReceivingFacility().getNamespaceID().setValue("VINAMED");

		msh.getMessageControlID().setValue(controlID + "");
		msh.getAcceptAcknowledgmentType().setValue("AL");
		msh.getApplicationAcknowledgmentType().setValue("NE");
		msh.getCountryCode().setValue("84");
		msh.insertCharacterSet(0).setValue("UNICODE UTF-8");
	}
	
	private static void setMSA(MSA msa, String code, int controlID) throws HL7Exception {
		msa.getMessageControlID().setValue(controlID + "");
		msa.getAcknowledgmentCode().setValue(code);
	}
	
	private static void setTQ1(TQ1 tq1) throws HL7Exception {
		tq1.getQuantity().getQuantity().setValue("1");
		tq1.getRepeatPattern(0).getRpt1_RepeatPatternCode().getIdentifier().setValue("Once");
		tq1.getStartDateTime().setValue(new Date());
		tq1.getPriority(0).getIdentifier().setValue(false ? "Y" : "N");
	}
	
	private static void setPRT(PRT prt) throws HL7Exception {
		String status = "U";
		
		prt.getActionCode().setValue(status);
		prt.getParticipation().getIdentifier().setValue("Equipment");
	}
	
	private static void setPID(PID pid) throws HL7Exception {
		pid.getPatientName(0).getFamilyName().getSurname().setValue("Pham Van Minh");
		pid.getPatientIdentifierList(0).getIDNumber().setValue("123456");
		pid.getPatientIdentifierList(0).getIdentifierCheckDigit().setValue("160912313");
		pid.getDateTimeOfBirth().setValue(new Date());
		pid.getAdministrativeSex().getIdentifier().setValue("M");
		pid.insertPatientAddress(0).getStreetAddress().getStreetOrMailingAddress().setValue("Ha Noi");
		pid.insertPhoneNumberHome(0).getXtn2_TelecommunicationUseCode().setValue("09");
	}
	
	private static void setIN1(IN1 in1) throws DataTypeException {
		in1.getHealthPlanID().getIdentifier().setValue("DN4");
		in1.getInsuranceCompanyID(0).getIDNumber().setValue("BHYT");
	}
	
	private static void setPV1(PV1 pv1) throws DataTypeException {
		
		CWE cwe = pv1.getPatientClass();
		cwe.getIdentifier().setValue(true ? "I" : "O");
		PL pl = pv1.getAssignedPatientLocation();
		
		pl.getBed().getNamespaceID().setValue("01");
		
		pl.getRoom().getNamespaceID().setValue("01" + "-" + "01");
		
		pl.getLocationDescription().setValue("KB" + "-" + "KB");
		
		pv1.getAttendingDoctor(0).getPersonIdentifier().setValue("Minh");
		pv1.getAttendingDoctor(0).getFamilyName().getSurname().setValue("Pham Van");
	}
	
	private static void setORC(ORC orc) throws DataTypeException {
		String status = "NW";
		
		orc.getOrderControl().setValue(status);
		orc.getPlacerOrderNumber().getEntityIdentifier().setValue("123456");
		
		orc.getFillerOrderNumber().getEntityIdentifier().setValue("001");
		orc.getPlacerGroupNumber().getEntityIdentifier().setValue("001");
		orc.getPlacerGroupNumber().getNamespaceID().setValue("HIS");
		orc.getFillerOrderNumber().getNamespaceID().setValue("01" + "-" + "01");
		
		orc.getOrderStatus().setValue("SC");
		orc.getFillerSExpectedAvailabilityDateTime().setValue(new Date());
		orc.getOrderType().getIdentifier().setValue(false ? "I" : "O");
		
		orc.getOrderingProvider(0).getPersonIdentifier().setValue("Minh");
		orc.getOrderingProvider(0).getFamilyName().getSurname().setValue("Pham Van");
	}
	
	private static void setOBR(OBR orb) throws DataTypeException {
		
		orb.getPlacerOrderNumber().getEntityIdentifier().setValue("123456");
		orb.getFillerOrderNumber().getEntityIdentifier().setValue("");
		orb.getFillerOrderNumber().getNamespaceID().setValue("" + "-" + "");
			
		orb.getFillerField1().setValue("" + "-" + "");
		
		orb.getUniversalServiceIdentifier().getIdentifier().setValue("");
		orb.getUniversalServiceIdentifier().getText().setValue("");
		orb.getOrderingProvider(0).getPersonIdentifier().setValue("");
		orb.getOrderingProvider(0).getFamilyName().getSurname().setValue("");
		orb.getPlacerField1().setValue("" + "-" + "");
		orb.getDiagnosticServSectID().setValue("");
		orb.getTransportationMode().setValue(true ? "PORT" : "WALK");
	}
	
	public static Message parseData(String data) throws HL7Exception {
		HapiContext context = null;
		try {
			context = new DefaultHapiContext();
			Parser parser = context.getPipeParser();
			
			return parser.parse(data);
			
		} finally {
			if(context != null) {
				try {
					context.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
