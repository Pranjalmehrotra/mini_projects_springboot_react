import logo from './logo.svg';
import './App.css';
import EmailSender from './component/EmailSender';
import { Toaster } from 'react-hot-toast';

function App() {
  return (
    <>
      <EmailSender/>
      <Toaster></Toaster>
      </>
  );
}

export default App;
