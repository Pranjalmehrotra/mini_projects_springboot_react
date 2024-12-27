import React from 'react'
import toast from 'react-hot-toast';
import { sendEmailWithoutFile } from '../services/email_service';
import { useState, useRef, useMemo } from 'react';
import JoditEditor from 'jodit-react';

function EmailSender() {

  const[emailRequest,setEmailRequest] = useState({
    senderemailAddress: '',
    emailSubject : '',
    emailMessageWithOrWithoutHtml:''
});

const editor = useRef(null);
	const [content, setContent] = useState('');

const handleChangeMultipleField = (event,property)=>{

  setEmailRequest({...emailRequest,
        [property]:event.target.value
    });
}

const submitEmailForm = (event)=>{
    event.preventDefault();
    console.log(emailRequest);
    if(emailRequest.senderemailAddress == "" || emailRequest.emailSubject == ""||
      emailRequest.emailMessageWithOrWithoutHtml ==""){
        toast.error("Invalid field");
        return;
      }
    //Api calling will take place
    try{
      sendEmailWithoutFile(emailRequest)
      toast.success("Email send successfully");

    }catch(error){
      console.log(error);
      toast.error("Email not send");

    }

}
  return (
    <div className="w-full min-h-screen flex justify-center items-center">
    <div className="email_card  w-1/3 p-4 rounded border shadow">
    <h1 className="text-gray-900 text-3xl">Email Sender</h1>
    <p className="text-gray-700">
        Send email to your favourite person with your own app
    </p>
    <form onSubmit = {submitEmailForm}
    class="max-w-sm mx-auto">
    {/* Sender email address textfield */}
  <div class="mb-5">
    <label for="email" 
    class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Sender email address</label>
    <input 
    value={emailRequest.senderemailAddress}
    onChange={(event)=>handleChangeMultipleField(event,"senderemailAddress")}
    type="email" 
    id="email" 
    class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" 
    placeholder="name@flowbite.com" required />
  </div>
  {/* Email Subject textfield */}
  <div class="mb-5">
    <label for="text" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Email Subject</label>
    <input 
    value={emailRequest.emailSubject}
    onChange={(event)=>handleChangeMultipleField(event,"emailSubject")}
    type="text" 
    id="text" 
    class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" required />
  </div>

  {/* Email Body textfield */}
  <div class="mb-5">
<label for="message" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your email message</label>
 <textarea 
value={emailRequest.emailMessageWithOrWithoutHtml}
onChange={(event)=>handleChangeMultipleField(event,"emailMessageWithOrWithoutHtml")}
id="message" 
rows="7" 
class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 
rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-
blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 
dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" 
placeholder="Write your email here..."></textarea> 
{/* <JoditEditor
			ref={editor}
			value={emailRequest.emailMessageWithOrWithoutHtml}
			tabIndex={1} // tabIndex of textarea
			//onBlur={newContent => setContent(newContent)} // preferred to use only this option to update the content for performance reasons
			onChange={newContent=>handleChangeMultipleField(event,"emailMessageWithOrWithoutHtml")}
		/> */}

  </div>
  <div class="flex items-start mb-5">
    <div class="flex items-center h-5">
      <input id="terms" type="checkbox" value="" class="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-blue-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:focus:ring-offset-gray-800" required />
    </div>
    <label for="terms" class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">I agree with the <a href="#" class="text-blue-600 hover:underline dark:text-blue-500">terms and conditions</a></label>
  </div>
  <div class="button_container flex justify-centre gap-3 mt-14" >
  <button type="submit" class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Send Email</button>
  <button class="text-white bg-black hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Cancel</button>

  </div>
  
</form>
    </div>
    </div>
  )
}

export default EmailSender;