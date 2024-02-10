import React from "react";

const AboutSection = () => {

    return (
        <div className="p-10 bg-slate-900 text-white">
            <p className="font-serif my-6">
                Welcome to Legal Questioner, where we've harnessed the power of artificial intelligence to demystify the complexities of legal documents. Our journey began with a mission - a mission to make legal information accessible, understandable, and empowering for everyone. At the core of our vision are the United Nations Sustainable Development Goals (SDGs), particularly SDG 4: Quality Education and SDG 16: Peace, Justice, and Strong Institutions.
            </p>
            <p className="font-serif my-6">
                In a world inundated with legal jargon and intricate documents, understanding the law should not be a privilege reserved for a select few. It should be a right, accessible to all. With this ethos in mind, we set out to create an innovative solution that not only fosters education but also contributes to building a just and peaceful society.
            </p>
            <p className="font-serif my-6">
                Our commitment to SDG 4 is reflected in our app's capability to provide quality legal education. By breaking down lengthy legal texts into easily digestible snippets, we enable users to comprehend complex information effortlessly. Whether you're a student studying law, a professional navigating contracts, or an individual seeking legal clarity, Legal Questioner ensures that everyone can access the knowledge they need.
            </p>
            <p className="font-serif my-6">
                Furthermore, our dedication to SDG 16 is evident in our pursuit of creating strong and transparent legal institutions. We understand that access to clear and concise legal information is crucial for fostering justice and maintaining peace within any society. Through our AI-powered app, we aim to bridge the information gap, empowering individuals to make informed decisions and contribute to a fair and just legal system.
            </p>
            <p className="font-serif my-6">
                As a testament to our commitment and innovation, we proudly present Legal Questioner, developed in just 24 hours for the GDSC Solutions Challenge Hackathon at McMaster University. The rapid development showcases not only our team's dedication but also the transformative potential of technology in addressing societal challenges.
            </p>
            <p className="font-serif mb-12">
                Join us on this journey towards a more informed, educated, and just world. With Legal Questioner, legal clarity is just a click away.
            </p>

            <a className= "bg-transparent hover:bg-white text-white font-serif hover:text-slate-900 py-2 px-4 border border-white"
                href="#Home">
                Back to the Top
            </a>
        </div>
    );
}

export default AboutSection;