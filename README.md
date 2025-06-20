# File Upload app using Spring boot framework

## Main class 
```java

public class FileUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadApplication.class, args);
	}
	

}

```
---
## Controller Class

- request Url for uploading file has a `MutipartFile` object  to handle the uploaded files
- form field holding files named `attach`

```java
@RequestMapping("/uploadFile") // request url
    @ResponseBody
    public String uploadFile(@RequestParam("attach")MultipartFile[] files)
    {
        boolean error = false;
        for (MultipartFile file: files)
        {
        System.out.println("fileName: " + file.getOriginalFilename());
        System.out.println("fileType: " + file.getContentType());

        String path = "D:\\Java Udacity\\file_upload\\src\\main\\resources\\static\\images\\";

        try {
            file.transferTo(new File(path + file.getOriginalFilename()));
        } catch (IllegalStateException e) {
            error = true;
            e.printStackTrace();
        } catch (IOException e) {
           error = true;
            e.printStackTrace();
        }
    }
        if(error)
            return "error uploading file";
        else

            return "file uploded sucessfully";



        
    }


```
---
## Html Page Front-end

- to upload a file using form :
    - method must be `post`
    - encoding type must be `multipart/form-data` to enable file uploading

```html
<h1>Hello World </h1>
    <img src="images/card.png" alt="card" >

    <form action="/uploadFile" method="post" enctype="multipart/form-data">
        <h3>Please upload your file here</h3>
        select file: <input type="file" name="attach" multiple="true">
        <input type="submit" value="upload">

    </form>

```


