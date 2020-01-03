package Service.ComManagement;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import Command.Spot.SpotCommand;
import Model.DTO.AuthInfo;
import Model.DTO.VspotDTO;
import Repository.Admin.AdminRepository;

@Service
public class AdminSpotService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	String original = null;
	String originalFileExtension = null;
	String store = null;
	
	@Transactional
	public Integer adminvspotWrite(SpotCommand spotCommand, HttpServletRequest request, HttpSession session) {
		
		VspotDTO spot = new VspotDTO();
		
		spot.setMemNum(((AuthInfo)session.getAttribute("authInfo")).getNum());
		spot.setMemId(((AuthInfo)session.getAttribute("authInfo")).getId());
		
		spot.setVspotTitle(spotCommand.getVspotTitle());
		spot.setVspotName(spotCommand.getVspotName());
		spot.setVspotLoc(spotCommand.getVspotLoc());
		spot.setVspotLocationMap(spotCommand.getVspotLocation2());
		spot.setVspotLocation("("+spotCommand.getVspotLocation1() +")"+ " " + spotCommand.getVspotLocation2()+ " " + spotCommand.getVspotLocation3());
		spot.setVspotIntroduce(spotCommand.getVspotIntroduce().replace("\n", "<br/>"));
		spot.setVspotFeature(spotCommand.getVspotFeature());
		
		
		String originalTotal = "";
		String storeTotal = "";
		
		for(MultipartFile mf : spotCommand.getVspotReport()) { 
			 original = mf.getOriginalFilename(); 
			 originalFileExtension = original.substring(original.lastIndexOf("."));  
			
			 store = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension; 

			 originalTotal += original + "-"; 
			 storeTotal += store + "-";

			 spot.setVspotOriginal(originalTotal); 
			 spot.setVspotStore(storeTotal);
		
			String path = request.getServletContext().getRealPath("/"); 
			 
			path += "WEB-INF/view/Spot/upload/"; 
			File file = new File(path+ store); 
			System.out.println();
			System.out.println(path);
			System.out.println();
			System.out.println(file);
			
			try {
				mf.transferTo(file); 
				
				
			} catch (Exception e) {
			
				e.printStackTrace();
			} 
			} 
		Integer result = adminRepository.adminvspotInsert(spot);
		
		return result;
		
	}

}
