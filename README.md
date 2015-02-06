# untargeted_demo

A demo of untargeted crawling.

Say a user creates an API on page: https://cookpad.com/en/recipes/171932-wheat-bran-and-walnut-bagels?ref=category

We download 1200 pages on cookpad. Then we run subotai on it and filter out pages similar to the original page.

The discovered pages are in [discoverd.txt](discovered.txt)
The complete list of pages are in [all.txt](all.txt)

336 pages were discovered. The end-points show that all these pages are quite close to the original and any API made on the original page can be applied to these pages.

