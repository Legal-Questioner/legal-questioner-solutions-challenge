import React from 'react'

const SearchBar = ({ searchInput, setSearchInput }) => {

    const handleChange = (e) => {
        e.preventDefault();
        setSearchInput(e.target.value);
    };

    return (
        <input className='w-3/5 outline p-1'
            type="text"
            placeholder="Type your question here..."
            onChange={handleChange}
            value={searchInput} />
    );
}

export default SearchBar;