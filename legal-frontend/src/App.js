import React, { useState, useEffect } from "react";
import axios from 'axios';
import './App.css';
import homeDesign from './images/HomeDesign.svg';
// import icon from './images/LegalLogo.svg';
import NavBar from './components/NavBar.js';
import SearchBar from './components/SearchBar.js';
import AboutSection from "./components/AboutSection.js";

function App() {
  const [searchInput, setSearchInput] = useState("");
  const [searchLinks, setSearchLinks] = useState("");
  const [searchContents, setsearchContents] = useState("");
  const [geminiResponse, setGeminiReponse] = useState("");

  const loadSearchResults = async ({ searchInput }) => {
    const response = await axios.post('http://localhost:3000/api/search', { input: searchInput });
    console.log(response);

    setSearchLinks(response.data.documentsLinks);
    setsearchContents(response.data.contents);
  }

  const querySearchResults = async ({ question , contents }) => {
    console.log(question);
    console.log(contents);

    const response = await axios.post('http://localhost:3000/api/query', { question: question, contents: contents });

    const respString = response.data.summary;
    console.log(respString);

    const startIndex = respString.indexOf('text: "');
    const endIndex = respString.indexOf('finish_reason:');

    console.log(startIndex, endIndex);
    setGeminiReponse(respString.substring(startIndex+7, endIndex-14).replace(/\\n/g, '').replace(/\\/g, ''));
  }

  useEffect(() => {
    if (searchContents !== "") {
      // Trigger querySearchResults when searchContents is updated
      querySearchResults({ question: searchInput, contents: searchContents });
    }
  }, [searchContents, searchInput]);

  return (
    <div className="App">

      <NavBar />
      <header id="Home" className='Home'>
        <div className='text-center'>
          <p className='header'>Get Legal Advice Quickly & Effectively</p>
          <p className='body'>We aim to provide everyone with the tools to be legally literate. Created for the GDSC Solutions Challenge 2024.</p>
        </div>
        <img src={homeDesign} className='Home-graphic' alt='homepage graphic' />
      </header>
      <header id='Search' className='Search'>

        <div className='text-center'>
          <p className='header mb-10'>Decode Legalese in Seconds</p>
          <p className='body mb-16'>Empower yourself with our AI tool that distills legal documents into bite-sized information, tailored to your specific questions.</p>
        </div>

        <SearchBar searchInput={searchInput} setSearchInput={setSearchInput} />

        <div className="my-10">
          <button className="bg-transparent hover:bg-slate-900 text-slate-950 font-serif hover:text-white py-2 px-4 border border-slate-950"
            onClick={() => loadSearchResults({ searchInput }) }>
            Search!
          </button>
        </div>

        <p className='header mt-10'>Response</p>
        <div className="font-serif mt-4 px-32">
          {geminiResponse ? geminiResponse : "Your answer will be shown here!"}
        </div>

        <p className='font-serif mt-6 font-bold'>{geminiResponse ? "Sources" : ""}</p>
        <a href={searchLinks[0]} target="_blank" rel="noreferrer" className="font-medium text-blue-600 underline dark:text-blue-500 hover:no-underline">
          {geminiResponse ? searchLinks[0] : ""}
        </a>

      </header>

      <header id="About" className='About'>

        <p className='header mt-40'>Our Story</p>
        <div className="mt-10">
          <AboutSection />
        </div>
      </header>
    </div>
  );
}

export default App;
