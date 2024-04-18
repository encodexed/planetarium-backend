# Planetarium

##### A fictional, pseudo-astrophysical Stars and Planets API utilising Java Spring and MySQL

![trevor-hope-mapping-the-sky-proper-sa](https://github.com/encodexed/planetarium-backend/assets/107448691/f65c0214-7604-4668-89a7-02fdf35075fd)
<sub><sup><b>Credit:</b> [Trevor Hope](https://www.artstation.com/artwork/L3Xbov)</sup></sub>

## Requirements / Purpose

This project forms the operational basis of a fictional universe that can be interacted with by users, or "explorers". Star systems, their stars and planets, can be explored and colonised based on a set amount of conditions and resources.

Informally, this project lets me work on fleshing out a complex RESTful Java Spring API and MySQL project as a form of practice.

**Tech Stack:** Java, Java Spring, MySQL

## Build Steps

To get this project running in your local environment, paste this into your terminal:

```bash
git clone git@github.com:encodexed/planetarium-backend.git
```

I recommend running the Java Spring application from its Main thread in your IDE of choice. I used IntellIJ Idea, Postman and MySQLWorkbench as part of my dev environment.

## Design Goals / Approach

- Writing a RESTful API that is able to create, read, update and delete star systems, stars and planets
- Applying pseudo-astrophysical constants and "smart" randomisation to the generation of new data
- Exploration of auth and other tricky concepts in the context of a Java Spring project

## Known issues

Nothing to worry about, yet.

Feel free to [raise an issue]('https://github.com/encodexed/planetarium-backend/issues') if you discover a bug or anything else.

## Future Goals

- Continue to add complexity to the project
- Documentation
- Testing
- Connect to a front-end project for a more intuitive UI/UX rather than relying on Postman
