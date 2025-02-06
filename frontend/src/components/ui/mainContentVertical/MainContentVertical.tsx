import { Box, Card, CardContent, CardMedia, Grid, Typography } from "@mui/material";
import { cardContentHoverStyle, CardContentStyle, cardContentTypoBox, CardStyling, picStyle } from "./MainContentVerticalStyles";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const placeholder = "./public/uploads/clubstep/Platzhalter_Clubbild.png"

export interface ClubType {
    id: number,
    name: string,
    disctrict: string,
    description: string,
    picAdresses: string[]
}


function MainContentVertical() {

    const [clubs, setClubs] = useState<ClubType[]>([])


    const urls = [
        'http://10.0.2.24:8080/api/home', // pc damago
    //  'http://192.168.178.28:8080/api/home', // pc home
      ];


        const fetchData = async() => {
                for(const url of urls) {
                    try {
                    console.log("iteration")
                    const response = await fetch(url)
                    if      (!response.ok) {throw new Error(`fetching ${url} failed`)}
                    else if ( response.ok) {
                        console.log(`fetching ${url} successful`)
                        const data = await response.json() 
                        return(data)
                    }
                } catch (error: unknown) {
                    if (error instanceof Error) {
                        console.log(`${error.message} at ${url}`)
                    } else {
                        console.log('unknown error for' + url)
                    }
                    continue;
                }
            } 
        }


    const loadData = async () => {
        const data = await fetchData()
        setClubs(data)
    }

    useEffect(() => {
        loadData()
    }, [])


      




    // hovering on Card & Link
    const [isHoverId, setHoverId] = useState<number | null>(null)

    function HoveredCard() {
        return (
            <Box id="hover-box" onClick={navToClubpage}
            sx={cardContentHoverStyle}>
                <Typography>
                    Text when hover
                </Typography>
            </Box>       
        )
    }

    const navigateToClubpage = useNavigate()
    function navToClubpage() {
        navigateToClubpage("/login")
    }
    //


    return(
        <Grid container spacing={1}>
            {clubs.map((club) => {
                return (
                    <Grid item key={club.id} xs={12} md={4}>
                    <Card sx={CardStyling} id={`main-content-card-${club.id}`}
                        onMouseEnter={() => {
                            setHoverId(club.id)
                            console.log(club.id)
                        }}
                        onMouseLeave={() => {
                            setHoverId(null)
                            console.log(isHoverId)    
                        }}
                    >
                            <CardContent sx={CardContentStyle} id={`"card-content-${club.id}"`}>
                                <Box sx={cardContentTypoBox}>
                                <Typography>
                                    {club.name}
                                </Typography>
                                </Box>
                                <CardMedia
                                    sx={picStyle}
                                    component={"img"}
                                    image={placeholder}>
                                </CardMedia>
                                {isHoverId === club.id &&  <HoveredCard/>}
                            </CardContent>
                        </Card>
                    </Grid>
                )
            })}
        </Grid>
    )
}


export default MainContentVertical