// const getData = async() => {
// 	var y = await "with await";
// 	console.log(y);
// }

// console.log("await1");
// getData();
// console.log("await2");

// const getDaa = async() => {
// 	var y =  "without await";
// 	console.log(y);
// }
// console.log("noawait1");
// getDaa();
// console.log("noawait2");


// let promise = new Promise(function (resolve, reject) {
//     setTimeout(function () {
//     resolve('Promise resolved')}, 4000); 
// });


// async function asyncFunc() {
//     try {
    
//         let result = await promise; 

//         console.log(result);
//     }   
//     catch(error) {
//         console.log(error);
//     }
// }


// asyncFunc();

// async function thisThrows() {
//     throw new Error("Thrown from thisThrows()");
// }

// async function run() {
//     try {
//         await thisThrows();
//     } catch (e) {
//         console.error(e);
//     } finally {
//         console.log('We do cleanup here');
//     }
// }

// run();

// let promise1;
// let promise2;
// let promise3;

// async function asyncFunc() {
//     let result1 = await promise1;
//     let result2 = await promise2;
//     let result3 = await promise3;

//     console.log(result1);
//     console.log(result1);
//     console.log(result1);
// }
const wish = new Promise((resolve, reject) => {
	resolve("Hello!");
  });

wish
  .then((value) => {
    console.log("The Promise is resolved!", value);
  })
  .catch((error) => {
    console.error("The Promise is rejected!", error);
  })
  .finally(() => {
    console.log(
      "The Promise is settled, meaning it has been resolved or rejected."
    );
  });
  //fetch(url)
//   .then((response) => response.json())
//   .then((data) => {
//     return {
//       data: data,
//       status: response.status,
//     };
//   })
//   .then((res) => {
//     console.log(res.data, res.status);
//   });