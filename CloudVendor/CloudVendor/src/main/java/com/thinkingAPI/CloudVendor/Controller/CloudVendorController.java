package com.thinkingAPI.CloudVendor.Controller;


import com.thinkingAPI.CloudVendor.Model.CloudVendor;
import com.thinkingAPI.CloudVendor.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restapi")

public class CloudVendorController
      {

         CloudVendorService cloudVendorService;
         public CloudVendorController(CloudVendorService cloudVendorService){
             this.cloudVendorService = cloudVendorService;
         }
        // Read Specific Cloud vendor Details from DB
        @GetMapping("{vendorId}")
        public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId)
        {
           return  cloudVendorService.getCloudVendor(vendorId);
        }
        // Read All Cloud Vendor Details from DB
          @GetMapping()
          public List<CloudVendor> getAllCloudVendorDetails()
          {
              return cloudVendorService.getAllCloudVendor();
          }

        @PostMapping
        public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
        {
            cloudVendorService.createCloudVendor(cloudVendor);
            return "Cloud Vendor Created Successfully";

        }
        @PutMapping
        public String UpdateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
        {
            cloudVendorService.updateCloudVendor(cloudVendor);
            return "Cloud Vendor Updated Successfully";

        }
        @DeleteMapping("{vendorId}")
        public String DeleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
        {
            cloudVendorService.deleteCloudVendor(vendorId);
            return "Cloud Vendor Deleted Successfully";

        }
    }

